package com.bobotw.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

public class LeaderboardPageTest extends PageTest {
    public LeaderboardPageTest(@Autowired MockMvc mockMvc) throws Exception {
        super(mockMvc, "/leaderboard");
    }

    @Test
    void titleIsCorrect() {
        assertThat(page.getTitleText()).isEqualTo("BOBOTW Leaderboard");
    }
}
