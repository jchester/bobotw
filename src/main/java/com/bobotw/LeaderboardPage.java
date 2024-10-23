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
        return html(
            head(
                meta().withCharset("utf-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                link().withRel("stylesheet").withHref("https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.classless.min.css"),
                title("BOBOTW Leaderboard")
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
            )
        ).withData("theme", "dark").render();
    }

    private DomContent videos() {
        List<Video> videos = entityManager.createNamedQuery("getVideos", Video.class).getResultList();

        return each(videos, video -> tr(
            td(video.getTitle()),
            td(Double.toString(video.getWinRatio()))
        ));
    }
}
