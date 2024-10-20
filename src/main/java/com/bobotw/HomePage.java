package com.bobotw;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static j2html.TagCreator.*;

@Path("/")
public class HomePage {
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
                        p("None of the Above by nunya bizness")
                    ).withId("best-of-best")
                )
            )
        ).withData("theme", "dark").render();
    }
}
