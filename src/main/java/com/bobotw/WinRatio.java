package com.bobotw;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "win_ratios")
public class WinRatio {
    @Id
    @Column(name = "video_id")
    private Long videoId;

    @Column(name = "ratio")
    private Double ratio;

    public Long getVideoId() {
        return videoId;
    }

    public Double getRatio() {
        return ratio;
    }
}
