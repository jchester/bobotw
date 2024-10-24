package com.bobotw;

import j2html.tags.DomContent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
                    p("The current Best of the Best is"),
                    bestVideo()
                ).withId("best-of-best")
            )
        );

        return fragment.getFragment().render();
    }

    private DomContent bestVideo() {
        Video video = entityManager.createQuery("select v from Video v order by winRatio limit 1", Video.class).getSingleResult();
        Episode episode = video.getEpisode();
        return div(
            h2(video.getTitle()),
            p("As seen in episode #" + episode.getId() + ", " + "\"" + episode.getTitle() + "\"")
        );
    }
}
