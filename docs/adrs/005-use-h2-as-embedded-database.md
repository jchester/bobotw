# Use H2 As Embedded Database

* Status: Accepted
* Principles: Play Is OK

## Problem and Motivation

Running a separate database costs memory and adds to operational complexity.

## Decision

Use H2 as an embedded database.

## Consequences

Fewer features than a fully fledged DB like PostgreSQL. Less documentation and weaker AI assistance. 

## Rationale

An embedded database does away with the overhead of a separate database process. It runs faster and is simple to manage:
there is nothing to launch or monitor. H2 is the most popular of the Java embedded databases. It runs fast and is quite
featuresome.
