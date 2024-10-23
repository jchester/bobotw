package com.bobotw;

import jakarta.persistence.*;

@Entity(name = "Video")
@Table(name = "videos")
@NamedQuery(name = "getVideos", query = "select v from Video v")
public class Video {
    @Id
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    private Episode episode;

    @OneToOne
    @Transient
    private WinRatio winRatio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public WinRatio getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(WinRatio winRatio) {
        this.winRatio = winRatio;
    }
}
