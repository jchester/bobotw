# Use HTMX

* Status: Accepted
* Principles: Build Complexity, Frontend Complexity
* See Also: [Use Java](002-use-java.md)

## Problem and Motivation

Modern frontend frameworks require extensive, complex toolchains.

## Decision

Usse HTMX as the basis of the frontend technology.

## Consequences

Complexity will move from frontend to backend. Performance will be worsened where networking is poor. Less documentation
and AI assistance will be available.

## Rationale

Frontend development's shift to Single-Page Application (SPA) frameworks like React has created a quagmire of complexity
and bloat. HTMX shifts the center of gravity back to the server, greatly simplifying builds and state management.
