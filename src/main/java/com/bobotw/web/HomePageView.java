package com.bobotw.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

import static j2html.TagCreator.*;

@Component
public class HomePageView implements View {
    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Video video = (Video) model.get("video");

        PageLayoutFragment fragment = new PageLayoutFragment(
            "Best of Best of the Worst",
            main(
                h1("Best of Best of the Worst"),
                div(
                    p("The current Best of the Best is"),
                    h2(video.title()),
                    p("As seen in the episode entitled \"" + video.episodeTitle() + "\"")
                ).withId("best-of-best")
            )
        );

        response.getWriter().write(fragment.getFragment().render());
    }
}
