package com.bobotw;

import jakarta.persistence.*;

@Entity(name = "Video")
@Table(name = "videos")
@NamedQuery(name = "getVideos", query = "select v from Video v order by winRatio asc")
public class Video {
    @Id
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    private Episode episode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "video_id")
    private WinRatio winRatio;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Episode getEpisode() {
        return episode;
    }

    public double getWinRatio() {
        if (winRatio == null) {
            return 0.0;
        } else {
            return winRatio.getRatio();
        }
    }
}
