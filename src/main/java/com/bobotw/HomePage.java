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

@Path("/")
public class HomePage {
    @PersistenceContext(name = "persistence1")
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String homepage() {
        PageFragment fragment = new PageFragment(
            "Best of Best of the Worst",
            main(
                h1("Best of Best of the Worst"),
                div(
                    h2("The current Best of the Best is"),
                    bestVideo()
                ).withId("best-of-best")
            )
        );

        return fragment.getFragment().render();
    }

    private DomContent bestVideo() {
        Video video = entityManager.createQuery("select v from Video v order by winRatio limit 1", Video.class).getSingleResult();
        return div("Title: " + video.getTitle());
    }

    private DomContent videos() {
        List<Video> videos = entityManager.createNamedQuery("getVideos", Video.class).getResultList();

        return each(videos, video -> li("Title: " + video.getTitle() + "  -- wins: " + video.getWinRatio() * 100 + "%"));
    }

    private DomContent episodes() {
        List<Episode> episodes = entityManager.createNamedQuery("getEpisodes", Episode.class).getResultList();

        return each(episodes, episode -> li(": " + episode.getTitle()));
    }
}
