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
                form(
                    div(
                        h2(leftVideo.title()),
                        button("Select as winner"),
                        input().isHidden().withName("winner").withValue(Long.toString(leftVideo.id())),
                        input().isHidden().withName("loser").withValue(Long.toString(rightVideo.id()))
                    )
                ).withMethod("post").withAction("/rank"),
                form(
                    div(
                        h2(rightVideo.title()),
                        button("Select as winner"),
                        input().isHidden().withName("winner").withValue(Long.toString(rightVideo.id())),
                        input().isHidden().withName("loser").withValue(Long.toString(leftVideo.id()))
                    )
                ).withMethod("post").withAction("/rank")
            )
        );

        response.getWriter().write(fragment.getFragment().render());
    }
}
