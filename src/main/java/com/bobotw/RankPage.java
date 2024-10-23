package com.bobotw;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static j2html.TagCreator.div;
import static j2html.TagCreator.main;

@Path("/rank")
public class RankPage {
    @PersistenceContext(name = "persistence1")
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String rank() {
        PageFragment fragment = new PageFragment(
            "Rank!",
            main(
                div().withId("option-1"),
                div().withId("option-2")
            )
        );

        return fragment.getFragment().render();
    }
}
