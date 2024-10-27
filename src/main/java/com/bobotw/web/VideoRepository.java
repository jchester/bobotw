package com.bobotw.web;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
    @Query("""
     select
       v.id
     , v.title
     , v.episode_id
     , wr.win_ratio
    from videos v join win_ratios wr on v.id = wr.video_id
    order by win_ratio desc
    limit 1
    """)
    Video findTopVideoByWinRatio();
}
