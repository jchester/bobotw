package com.bobotw.web;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface VideoRepository extends CrudRepository<Video, Long> {
    @Query("""
         select
           id
         , title
         , episode_title
         , win_ratio
        from videos_with_win_ratios
        order by win_ratio desc
        limit 1
        """)
    Video findTopVideoByWinRatio();

    List<Video> findAllByOrderByWinRatioDesc();

    @Query("""
        select l.id as left_id
             , r.id as right_id
        from videos_with_win_ratios l
                 join videos_with_win_ratios r on l.id <> r.id
          where not exists(select 1
                         from pair_rankings
                         where ranker_id = :ranker
                           and winner_id in (l.id, r.id)
                           and loser_id in (l.id, r.id))
        order by cast(l.appearances as decimal) + cast(r.appearances as decimal) + random()
        limit 1
        """)
    VideoPair findCandidateVideoPairForRanker(@Param("ranker") UUID ranker);
}
