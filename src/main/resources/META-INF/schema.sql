create table episodes
(
    id    integer       not null,
    title varchar(1000) not null,

    primary key (id)
);

create table videos
(
    id         integer       not null,
    title      varchar(1000) not null,
    episode_id bigint        not null,

    primary key (id)
);