package com.bobotw;

import org.junit.jupiter.api.Test;

import static j2html.TagCreator.main;
import static j2html.TagCreator.p;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class PageFragmentTest {
    PageFragment pageFragment = new PageFragment("Best of Best of the Worst", main(p("Test content")));
    String rendered = pageFragment.getFragment().render();

    @Test
    void setsCharsetToUTF8() {
        assertThat(rendered, containsString("<meta charset=\"utf-8\">"));
    }

    @Test
    void setsViewportSize() {
        assertThat(rendered, containsString("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"));
    }

    @Test
    void setsPicoClasslessCssStylesheet() {
        assertThat(rendered, containsString("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.classless.min.css\">"));
    }

    @Test
    void providesNavLinks() {
        assertThat(rendered, containsString("<nav>"));
        assertThat(rendered, containsString("</nav>"));

        assertThat(rendered, containsString("<li><a href=\"/\">Home</a></li>"));
        assertThat(rendered, containsString("<li><a href=\"/rank\">Rank</a></li>"));
        assertThat(rendered, containsString("<li><a href=\"/leaderboard\">Leaderboard</a></li>"));
        assertThat(rendered, containsString("<li><a href=\"/about\">About</a></li>"));
    }

    @Test
    void interpolatesMainContent() {
        assertThat(rendered, containsString("<p>Test content</p>"));
    }
}
