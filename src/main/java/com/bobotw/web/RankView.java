package com.bobotw.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

import static j2html.TagCreator.*;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Component
public class RankView implements View {
    @Override
    public String getContentType() {
        return TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Video leftVideo = (Video) model.get("leftVideo");
        Video rightVideo = (Video) model.get("rightVideo");

        PageLayoutFragment fragment = new PageLayoutFragment(
            "BOBOTW: Rank!",
            main(
                div(
                    h2(leftVideo.title())
                ),
                div(
                    h2(rightVideo.title())
                )
            )
        );

        response.getWriter().write(fragment.getFragment().render());
    }
}
