package com.bobotw.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/leaderboard")
public class LeaderboardController {
    final VideoRepository videoRepository;

    public LeaderboardController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping
    public String leaderboard(Model model) {
        List<Video> videos = (List<Video>) videoRepository.findAll();

        model.addAttribute("videos", videos);

        return "leaderboardPageView";
    }
}
