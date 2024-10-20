package com.bobotw;

import jakarta.persistence.*;

@Entity(name = "Episode")
@Table(name = "episodes")
@NamedQuery(name = "getEpisodes", query = "select e from Episode e")
public class Episode {
    private int id;
    private String title;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
