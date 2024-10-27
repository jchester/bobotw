package com.bobotw.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

import static j2html.TagCreator.div;
import static j2html.TagCreator.p;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Component
public class RankView implements View {
    @Override
    public String getContentType() {
        return TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageLayoutFragment fragment = new PageLayoutFragment(
            "BOBOTW: Rank!",
            div(
                p("Just rank it")
            )
        );

        response.getWriter().write(fragment.getFragment().render());
    }
}
