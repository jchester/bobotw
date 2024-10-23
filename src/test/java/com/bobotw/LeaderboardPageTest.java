package com.bobotw;

import io.helidon.microprofile.testing.junit5.HelidonTest;
import org.htmlunit.WebClient;
import org.htmlunit.html.DomElement;
import org.htmlunit.html.DomNodeList;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@HelidonTest
public class LeaderboardPageTest {
    private final WebClient webClient = new WebClient();
    private final HtmlPage page = webClient.getPage("http://localhost:8080/leaderboard");

    public LeaderboardPageTest() throws IOException {
    }

    @Test
    void titleIsCorrect() {
        assertThat(page.getTitleText(), is("BOBOTW Leaderboard"));
    }

    @Test
    void itHasATableOfBests() {
        final DomNodeList<DomElement> rows = page.getElementsByTagName("tr");
        assertThat(rows, notNullValue());

        assertThat(rows.getLength(), is(5));
    }
}
