package com.bobotw.web;

import j2html.tags.DomContent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;
import static org.springframework.http.MediaType.*;

@Component
public class LeaderboardPageView implements View {
    @Override
    public String getContentType() {
        return TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Video> videos = (List<Video>) model.get("videos");

        PageLayoutFragment fragment = new PageLayoutFragment(
            "BOBOTW Leaderboard",
            main(
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
            td(Double.toString(video.winRatio()))
        ));
    }

}
