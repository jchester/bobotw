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
public class RankView implements View {
    @Override
    public String getContentType() {
        return TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Video leftVideo = (Video) model.get("leftVideo");
        Video rightVideo = (Video) model.get("rightVideo");
        List<Tag> leftTags = (List<Tag>) model.get("leftTags");
        List<Tag> rightTags = (List<Tag>) model.get("rightTags");
        Long rankedCount = (Long) model.get("rankedCount");
        Long possibleCount = (Long) model.get("possibleCount");

        PageLayoutFragment fragment = new PageLayoutFragment(
            "BOBOTW: Rank!",
            main(
                link().withRel("stylesheet").withHref("/style/rank.css"),
                p("You have ranked " + rankedCount + "/" + possibleCount + " matchups."),
                form(
                    div(
                        button("Select as winner"),
                        h2(leftVideo.title()),
                        img().withSrc("/images/jay-bauman.jpg"),
                        input().isHidden().withName("winner").withValue(Long.toString(leftVideo.id())),
                        input().isHidden().withName("loser").withValue(Long.toString(rightVideo.id())),
                        div(
                            tags(leftTags)
                        ).withClass("tags")
                    ).withClass("card")
                ).withMethod("post").withAction("/rank"),
                form(
                    div(
                        button("Select as winner"),
                        h2(rightVideo.title()),
                        img().withSrc("/images/mike-stoklasa.jpg"),
                        input().isHidden().withName("winner").withValue(Long.toString(rightVideo.id())),
                        input().isHidden().withName("loser").withValue(Long.toString(leftVideo.id())),
                        div(
                            tags(rightTags)
                        ).withClass("tags")
                    ).withClass("card")
                ).withMethod("post").withAction("/rank")
            )
        );

        response.getWriter().write(fragment.getFragment().render());
    }

    private DomContent tags(List<Tag> tags) {
        return each(tags, tag -> span(
            tag.text())
            .withClass("tag")
            .withStyle("background-color: " + tag.color()
            )
        );
    }
}
