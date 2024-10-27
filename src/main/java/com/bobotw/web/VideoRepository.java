package com.bobotw.web;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

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
}
