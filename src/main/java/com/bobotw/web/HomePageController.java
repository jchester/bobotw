package com.bobotw.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    final VideoRepository videoRepository;
    final EpisodeRepository episodeRepository;

    public HomePageController(VideoRepository videoRepository, EpisodeRepository episodeRepository) {
        this.videoRepository = videoRepository;
        this.episodeRepository = episodeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        Video video = videoRepository.findTopVideoByWinRatio();
        Episode episode = episodeRepository.findById(video.episodeId()).get();
        model.addAttribute("video", video);
        model.addAttribute("episode", episode);

        return "homePageView";
    }
}
