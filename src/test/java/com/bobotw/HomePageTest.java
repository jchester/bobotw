package com.bobotw;

import io.helidon.microprofile.testing.junit5.HelidonTest;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@HelidonTest
public class HomePageTest {
    @Test
    void titleIsCorrect() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://localhost:8080/");
            assertThat(page.getTitleText(), is("Best of Best of the Worst"));
        }
    }
}
