package com.bobotw;

import io.helidon.microprofile.testing.junit5.HelidonTest;
import org.htmlunit.WebClient;
import org.htmlunit.html.DomElement;
import org.htmlunit.html.HtmlAnchor;
import org.htmlunit.html.HtmlMeta;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@HelidonTest
public class HomePageTest {
    private final WebClient webClient = new WebClient();
    private final HtmlPage page = webClient.getPage("http://localhost:8080/");

    public HomePageTest() throws IOException {
    }

    @Test
    void titleIsCorrect() {
        assertThat(page.getTitleText(), is("Best of Best of the Worst"));
    }

    @Test
    void setsCharsetToUTF8() {
        assertThat(page.getCharset().displayName(), is("UTF-8"));
    }

    @Test
    void setsViewportSize() {
        List<HtmlMeta> metaTags = page.getByXPath("/html/head/meta");
        Optional<HtmlMeta> viewportMeta = metaTags.stream().filter(t -> t.getNameAttribute().equals("viewport")).findFirst();
        assertThat(viewportMeta.isPresent(), is(true));
        assertThat(viewportMeta.get().getContentAttribute(), is("width=device-width, initial-scale=1.0"));
    }

    @Test
    void setsPicoClasslessCssStylesheet() {
        assertThat(page.getStyleSheets().getFirst().getUri(), containsString("pico.classless.min.css"));
    }

    @Test
    void providesNavLinks() {
        final DomElement nav = page.getElementsByTagName("nav").getFirst();
        assertThat(nav, notNullValue());

        HtmlAnchor homeLink = page.getAnchorByText("Home");
        assertThat(homeLink.getHrefAttribute(), is("/"));

        HtmlAnchor voteLink = page.getAnchorByText("Vote");
        assertThat(voteLink.getHrefAttribute(), is("/vote"));

        HtmlAnchor leaderboardLink = page.getAnchorByText("Leaderboard");
        assertThat(leaderboardLink.getHrefAttribute(), is("/leaderboard"));

        HtmlAnchor aboutLink = page.getAnchorByText("About");
        assertThat(aboutLink.getHrefAttribute(), is("/about"));
    }
}
