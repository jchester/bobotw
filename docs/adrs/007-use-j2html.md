# Use j2html

* Status: Accepted
* Principles: Build Complexity, Frontend Complexity
* See Also: [Use Java](002-use-java.md), [Use HTMX](006-use-htmx.md)

## Problem and Motivation

All HTML construction will be done server-side. Some mechanism for rendering HTML is required. None is built into
Helidon, which focuses on the JSON API usecase

## Decision

Use the j2html library to generate HTML.

## Consequences

Some HTML authoring tasks will be more difficult because the original source will be in Java, not HTML fragments in a
rendering engine.

j2html is only developed by a small group of people, who might lose interest or neglect the code.

## Rationale

j2html is very fast compared to conventional templating engines. It also provides type-safe construction, which makes it
less likely that pages will be silently broken. Finally, because it is "just" functions, it is highly testable.
