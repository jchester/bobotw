package com.bobotw.web;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LeaderboardPageTest {
    private final WebClient webClient = new WebClient();
    private final HtmlPage page = webClient.getPage("http://localhost:8080/leaderboard");

    public LeaderboardPageTest() throws IOException {
    }

    @Test
    void titleIsCorrect() {
        assertThat(page.getTitleText()).isEqualTo("BOBOTW Leaderboard");
    }
}
