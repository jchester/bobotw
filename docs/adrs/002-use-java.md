# Use Java

* Status: Accepted
* Principles: Build Complexity, Play Is OK

## Problem and Motivation

Every architecture needs to use at least one programming language and ecosystem. Sometimes more than one ecosystem must
be used, but this comes at a high price, particularly in build complexity. Distributing logic among code in different
languages increases the complexity of development and increases the likelihood of bugs.

## Decision

Use Java as the default language; stay in Java as much as possible.

## Consequences

Some technologies found in other ecosystems may be unavailable, requiring a workaround, replacement or dropping a
feature.

## Rationale

Java is a relatively simple language with many desirable properties. It has a huge ecosystem of packages, enormous
troves of documentation, is highly observable with multiple mature and performant runtimes. In addition, professional
assistance is widely available for insoluble questions.
