create table if not exists videos
(
    video_id      integer primary key autoincrement,
    title         text not null,
    episode_title text not null
);

create table if not exists tags
(
    tag_id integer primary key autoincrement,
    text   text not null,
    color  text not null
);

create table if not exists tags_on_videos
(
    tov_id   integer primary key autoincrement,
    video_id integer not null references videos (video_id),
    tag_id   integer not null references tags (tag_id),

    unique (video_id, tag_id)
);

create table if not exists rankers
(
    ranker_id uuid primary key
);

create table if not exists pair_rankings
(
    pair_id   integer primary key autoincrement,
    ranker_id uuid    not null references rankers (ranker_id),
    winner_id integer not null references videos (video_id),
    loser_id  integer not null references videos (video_id),

    unique (ranker_id, winner_id, loser_id),
    check (winner_id <> loser_id)
);

create index if not exists rank_winners on pair_rankings (winner_id);
create index if not exists rank_losers on pair_rankings (loser_id);
create index if not exists rank_rankers on pair_rankings (ranker_id);

create view wins as
select winner_id as video_id,
       count(1)  as wins
from pair_rankings
group by winner_id
;

create view losses as
select loser_id as video_id
     , count(1) as losses
from pair_rankings
group by loser_id
;

create view win_ratios as
select videos.video_id                                     as video_id
     , coalesce(wins.wins, 0)                              as wins
     , coalesce(losses.losses, 0)                          as losses
     , coalesce(wins.wins, 0) + coalesce(losses.losses, 0) as appearances
from videos
         left outer join wins on videos.video_id = wins.video_id
         left outer join losses on videos.video_id = losses.video_id
;

create view videos_with_confidence_bounds as
with scored as (select v.video_id
                     , v.title
                     , v.episode_title
                     , wr.appearances
                     , case
                           when wr.appearances > 0 then
                               -- https://www.evanmiller.org/how-not-to-sort-by-average-rating.html
                               ((wr.wins + 1.9208) / wr.appearances -
                                1.96 * sqrt((wr.wins * wr.losses) / wr.appearances + 0.9604) /
                                wr.appearances) / (1 + 3.8416 / wr.appearances)
                           else
                               0
        end as confidence_lower_bound
                from videos v
                         join win_ratios wr on v.video_id = wr.video_id
                order by confidence_lower_bound desc, appearances desc)
select dense_rank() over (
    order by confidence_lower_bound desc, appearances desc
    ) as rank
     , video_id
     , title
     , episode_title
     , appearances
     , confidence_lower_bound
from scored
;
