package com.bobotw.web;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Long> {
    @Query("""
            select
                t.id,
                t.text
            from tags t
            join tags_on_videos tov on t.id = tov.tag_id
            where tov.video_id = :videoId
        """)
    List<Tag> findTagsForVideo(@Param("videoId") Long videoId);
}
