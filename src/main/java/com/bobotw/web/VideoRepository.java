package com.bobotw.web;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Long> {
    @Query("""
         select
           id
         , title
         , episode_id
         , win_ratio
        from videos_with_win_ratios
        order by win_ratio desc
        limit 1
        """)
    Video findTopVideoByWinRatio();

    List<Video> findAllByOrderByWinRatioDesc();

    @Query("""
        select
            id
          , title
          , episode_id
          , win_ratio
          from videos_with_win_ratios
          order by cast(appearances as decimal) + random()
          limit 1
        """)
    Video findCandidateVideo();

    @Query("""
        select
                    id
                  , title
                  , episode_id
                  , win_ratio
                  from videos_with_win_ratios
                  where id <> :id
                  order by cast(appearances as decimal) + random()
                  limit 1
        """)
    Video findCandidateVideoExceptId(@Param("id") Long id);
}
