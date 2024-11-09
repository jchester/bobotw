package com.bobotw.web;

import j2html.tags.DomContent;

import static j2html.TagCreator.*;

public class PageLayoutFragment {
    private final String title;
    private final DomContent mainContent;

    public PageLayoutFragment(String title, DomContent mainContent) {
        this.title = title;
        this.mainContent = mainContent;
    }

    public DomContent getFragment() {
        return html(
            head(
                meta().withCharset("utf-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                link().withRel("stylesheet").withHref("https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.classless.min.css"),
                title(title)
            ),
            body(
                header(
                    nav(
                        ul(
                            li(a().withText("Home").withHref("/")),
                            li(a().withText("Rank").withHref("/rank")),
                            li(a().withText("Leaderboard").withHref("/leaderboard")),
                            li(a().withText("About").withHref("/about"))
                        )
                    )
                ),
                mainContent,
                footer(
                    p(em("This site is in no way affiliated with \"Toy Story\" or Red Letter Media."))
                )
            )
        ).withData("theme", "dark");
    }
}
