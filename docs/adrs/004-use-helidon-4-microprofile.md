# Use Helidon 4 MicroProfile

* Status: Accepted
* Principles: Play Is OK

## Problem and Motivation

["Use a simple concurrency model"](003-use-a-simple-concurrency-model.md) requires us to use Java virtual threads for
concurrency. Not all frameworks have truly digested this shift in concurrency thinking.

While "Play Is OK", the amount of play being tried at once needs to be considered.

Memory needs to be conserved to fit the limited RAM budget of a small VPS.

## Decision

Use Helidon 4 MicroProfile.

## Consequences

Less documentation, fewer integrations, worse AI assistant performance. Easier development as MicroProfile is more like
Spring Boot than the SE variant.

## Rationale

Helidon is designed from the ground up to leverage virtual threading. It provides two programming models, one of which
exposes the MicroProfile (MP) APIs and tools. The MP model resembles Spring Boot and will be more familiar to me.

Helidon is also memory-efficient, especially when compiled to native image.
