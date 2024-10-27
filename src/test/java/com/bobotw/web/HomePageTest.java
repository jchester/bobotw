package com.bobotw.web;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomePageTest {
    private final HtmlPage page;

    public HomePageTest(@Autowired MockMvc mockMvc) throws Exception {
        MvcResult result = mockMvc.perform(get("/")).andExpect(status().isOk()).andReturn();
        String htmlAsString = result.getResponse().getContentAsString();
        try (WebClient webClient = new WebClient()) {
            page = webClient.loadHtmlCodeIntoCurrentWindow(htmlAsString);
        }
    }

    @Test
    void titleIsCorrect() {
        assertThat(page.getTitleText()).isEqualTo("Best of Best of the Worst");
    }
}
