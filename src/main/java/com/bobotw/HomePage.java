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
        return html(
            head(
                meta().withCharset("utf-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                link().withRel("stylesheet").withHref("https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.classless.min.css"),
                title("Best of Best of the Worst")
            ),
            body(
                header(
                    nav(
                        ul(
                            li(a().withText("Home").withHref("/")),
                            li(a().withText("Vote").withHref("/vote")),
                            li(a().withText("Leaderboard").withHref("/leaderboard")),
                            li(a().withText("About").withHref("/about"))
                        )
                    )
                ),
                main(
                    h1("Best of Best of the Worst"),
                    div(
                        h2("The current Best of the Best is"),
                        bestVideo()
                    ).withId("best-of-best"),
                    ol(
                        videos()
                    )
                )
            )
        ).withData("theme", "dark").render();
    }

    private DomContent bestVideo() {
        Video video = entityManager.createQuery("select v from Video v order by winRatio limit 1", Video.class).getSingleResult();
        return div().withText("Title: " + video.getTitle());
    }

    private DomContent videos() {
        List<Video> videos = entityManager.createNamedQuery("getVideos", Video.class).getResultList();

        return each(videos, video -> li("Title: " + video.getTitle() + "  -- win ratio: " + video.getWinRatio()));
    }

    private DomContent episodes() {
        List<Episode> episodes = entityManager.createNamedQuery("getEpisodes", Episode.class).getResultList();

        return each(episodes, episode -> li(": " + episode.getTitle()));
    }
}
