package com.bobotw.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePageTest extends PageTest {
    public HomePageTest(@Autowired MockMvc mockMvc) throws Exception {
        super(mockMvc, "/");
    }

    @Test
    void titleIsCorrect() {
        assertThat(page.getTitleText()).isEqualTo("Best of Best of the Worst");
    }
}
