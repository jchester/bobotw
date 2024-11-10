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
    final PairRankingRepository pairRankingRepository;

    public LeaderboardController(VideoRepository videoRepository, PairRankingRepository pairRankingRepository) {
        this.videoRepository = videoRepository;
        this.pairRankingRepository = pairRankingRepository;
    }

    @GetMapping
    public String leaderboard(Model model) {
        List<Video> videos = videoRepository.findAllByOrderByConfidenceLowerBoundDesc();
        model.addAttribute("videos", videos);

        long countOfRankings = pairRankingRepository.count();
        model.addAttribute("countOfRankings", countOfRankings);

        return "leaderboardPageView";
    }
}
