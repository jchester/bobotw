package com.bobotw.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    final VideoRepository videoRepository;

    public HomePageController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        Video video = videoRepository.findTopVideoByOrderByWinRatioDesc();
        model.addAttribute("video", video);

        return "homePageView";
    }
}
