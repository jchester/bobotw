package com.bobotw.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

import static j2html.TagCreator.*;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Component
public class NoMoreRankView implements View {
    @Override
    public String getContentType() {
        return TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageLayoutFragment fragment = new PageLayoutFragment("BOBOTW: Stop Ranking!",
            main(
                style("""
                        img {
                        text-align: center;
                        }
                    """),
                h1("You ranked everything! Please come back when there is a new episode."),
                img().withSrc("/images/rich-evans.jpg")
            )
        );

        response.getWriter().write(fragment.getFragment().render());
    }
}
