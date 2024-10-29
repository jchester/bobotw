package com.bobotw.web;

import com.fasterxml.uuid.Generators;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class RankController {
    final VideoRepository videoRepository;
    final PairRankingRepository pairRankingRepository;
    private final RankerRepository rankerRepository;
    JdbcAggregateTemplate jdbcAggregateTemplate;

    public RankController(VideoRepository videoRepository, RankerRepository rankerRepository, PairRankingRepository pairRankingRepository, JdbcAggregateTemplate jdbcAggregateTemplate) {
        this.videoRepository = videoRepository;
        this.pairRankingRepository = pairRankingRepository;
        this.jdbcAggregateTemplate = jdbcAggregateTemplate;
        this.rankerRepository = rankerRepository;
    }

    @GetMapping("/rank")
    public ModelAndView rank(Model model, @CookieValue(value = "ranker") @Nullable UUID ranker, HttpServletResponse response) {
        if (ranker == null) {
            UUID newUuid = Generators.timeBasedEpochRandomGenerator().generate();

            // This ought to be a RankerRepository, but for reasons I don't understand it doesn't work.
            // The JDBC aggregate template goes one level lower and _does_ work, so here it goes,
            jdbcAggregateTemplate.insert(new Ranker(newUuid));

            Cookie newCookie = new Cookie("ranker", newUuid.toString());
            newCookie.setMaxAge(365 * 24 * 60 * 60);
//            newCookie.setDomain("localhost");
            newCookie.setPath("/");
            newCookie.setHttpOnly(true);
            newCookie.setSecure(false);

            response.addCookie(newCookie);
        } else {
            // Deal with case where process has restarted and forgotten an existing cookie
            if (!rankerRepository.existsById(ranker)) {
                jdbcAggregateTemplate.insert(new Ranker(ranker));
            }
        }

        Video leftVideo = videoRepository.findCandidateVideo();
        model.addAttribute("leftVideo", leftVideo);

        Video rightVideo = videoRepository.findCandidateVideoExceptId(leftVideo.id());
        model.addAttribute("rightVideo", rightVideo);

        return new ModelAndView("rankView");
    }

    @PostMapping("/rank")
    public ModelAndView rankSubmit(@CookieValue("ranker") UUID rankerId, @RequestParam("winner") Long winnerId, @RequestParam("loser") Long loserId) {
        PairRanking newRanking = new PairRanking(null, rankerId, winnerId, loserId);
        pairRankingRepository.save(newRanking);

        return new ModelAndView("redirect:/rank");
    }
}
