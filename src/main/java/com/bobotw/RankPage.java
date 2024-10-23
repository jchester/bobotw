package com.bobotw;

import com.fasterxml.uuid.Generators;
import j2html.tags.DomContent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

import static j2html.TagCreator.div;
import static j2html.TagCreator.main;

@Path("/rank")
public class RankPage {
    private static final int A_YEAR_IN_SECONDS = 30_879_000;
    @PersistenceContext(name = "persistence1")
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response rank(@CookieParam("bobotw") Cookie cookie) {
        UUID uuid = Generators.timeBasedEpochGenerator().generate();

        if (cookie == null) {
            Ranker newRanker = new Ranker();
            newRanker.setId(uuid);
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newRanker);
            transaction.commit();

            PageFragment fragment = new PageFragment(
                "Rank!",
                main(
                    yetToBeRanked()
                )
            );

            NewCookie newCookie = new NewCookie.Builder("bobotw")
                .value(uuid.toString())
                .domain("localhost") // TODO fix when running on bobotw.com
                .path("/rank")
                .httpOnly(true)
                .secure(true)
                .sameSite(NewCookie.SameSite.STRICT)
                .maxAge(A_YEAR_IN_SECONDS)
                .build();

            return Response.ok(fragment.getFragment().render()).cookie(newCookie).build();
        } else {
            PageFragment fragment = new PageFragment(
                "Rank!",
                main(
                    anyTwo()
                )
            );

            return Response.ok(fragment.getFragment().render()).build();
        }
    }

    public DomContent yetToBeRanked() {
        return div(
            div().withId("option-1"),
            div().withId("option-2")
        );
    }

    public DomContent anyTwo() {
        return div(
            div().withId("option-1"),
            div().withId("option-2")
        );
    }
}
