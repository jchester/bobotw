package com.bobotw.web;

import j2html.tags.DomContent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Component
public class LeaderboardPageView implements View {
    private static final Double TO_PERCENT = 100.0;

    @Override
    public String getContentType() {
        return TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Video> videos = (List<Video>) model.get("videos");
        Long countOfRankings = (Long) model.get("countOfRankings");

        PageLayoutFragment fragment = new PageLayoutFragment(
            "BOBOTW Leaderboard",
            main(
                p("With " + countOfRankings + " rankings submitted:"),
                table(
                    thead(
                        tr(
                            th("Title"),
                            th("Win Ratio")
                        )
                    ),
                    tbody(
                        videos(videos)
                    )
                )
            )
        );

        response.getWriter().write(fragment.getFragment().render());
    }

    private DomContent videos(List<Video> videos) {
        return each(videos, video -> tr(
            td(video.title()),
            td(String.format("%.2f", video.winRatio() * TO_PERCENT))
        ));
    }

}
