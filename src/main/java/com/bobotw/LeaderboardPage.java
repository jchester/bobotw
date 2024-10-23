package com.bobotw;

import j2html.tags.DomContent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static j2html.TagCreator.*;

@Path("/leaderboard")
public class LeaderboardPage {
    @PersistenceContext(name = "persistence1")
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String leaderboard() {
        PageFragment fragment = new PageFragment(
            "BOBOTW Leaderboard",
            main(
                table(
                    thead(
                        tr(
                            th("Title"),
                            th("Win Ratio")
                        )
                    ),
                    tbody(
                        videos()
                    )
                )
            )
        );

        return fragment.getFragment().render();
    }

    private DomContent videos() {
        List<Video> videos = entityManager.createNamedQuery("getVideos", Video.class).getResultList();

        return each(videos, video -> tr(
            td(video.getTitle()),
            td(Double.toString(video.getWinRatio()))
        ));
    }
}
