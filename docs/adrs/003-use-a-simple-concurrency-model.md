# Use a Simple Concurrency Model

* Status: Accepted
* Principles: Play Is OK

## Problem and Motivation

Classical 1:1 threading struggles with unpredictable load. Reactive APIs deal effectively with concurrency but are very
difficult to reason about.

## Decision

Use conventional Java thread-based concurrency, using virtual threads.

## Consequences

Reactive libraries will not be usable. Backpressure will not be built into the design.

## Rationale

Reactive, async/await and callback concurrency models are difficult to reason about, difficult to test and difficult to
observe. Virtual threads, introduced in Java 21, provide most of the scalability benefit of these alternative models
without sacrificing the advantages of conventional threading.
