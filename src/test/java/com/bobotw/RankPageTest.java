package com.bobotw;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.htmlunit.util.Cookie;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

    @Test
    void itSetsACookie() throws URISyntaxException, MalformedURLException {
        Set<Cookie> cookies = webClient.getCookies(new URI("http://localhost:8080/rank").toURL());

        assertThat(cookies, hasSize(1));

        Cookie cookie = cookies.stream().findFirst().get();

        assertThat(cookie.getName(), is("bobotw"));
        assertThat(cookie.getDomain(), is("localhost")); // TODO make this general for bobotw.com
        assertThat(cookie.getPath(), is("/rank"));
        assertThat(cookie.isHttpOnly(), is(true));
        assertThat(cookie.isSecure(), is(true));
        assertThat(cookie.getSameSite(), is("strict"));
    }
}
