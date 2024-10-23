package com.bobotw;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RankPageTest {
    private final WebClient webClient = new WebClient();
    private final HtmlPage page = webClient.getPage("http://localhost:8080/rank");

    public RankPageTest() throws IOException {
    }

    @Test
    void titleIsCorrect() {
        assertThat(page.getTitleText(), is("Rank!"));
    }

    @Test
    void hasTwoOptions() {
        assertThat(page.getElementById("option-1"), notNullValue());
        assertThat(page.getElementById("option-2"), notNullValue());
    }
}
