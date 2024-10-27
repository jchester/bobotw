package com.bobotw.web;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PageTest {
    protected final HtmlPage page;

    public PageTest(@Autowired MockMvc mockMvc, String path) throws Exception {
        MvcResult result = mockMvc.perform(get(path)).andExpect(status().isOk()).andReturn();
        String htmlAsString = result.getResponse().getContentAsString();
        try (WebClient webClient = new WebClient()) {
            page = webClient.loadHtmlCodeIntoCurrentWindow(htmlAsString);
        }
    }
}
