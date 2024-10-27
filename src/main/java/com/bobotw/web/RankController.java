package com.bobotw.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankController {
    final VideoRepository videoRepository;

    public RankController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/rank")
    public String rank(Model model) {
        Video leftVideo = videoRepository.findCandidateVideo();
        model.addAttribute("leftVideo", leftVideo);

        Video rightVideo = videoRepository.findCandidateVideoExceptId(leftVideo.id());
        model.addAttribute("rightVideo", rightVideo);

        return "rankView";
    }
}
