# Architectural Principles

These are general principles to guide architectural decisions.

## Build Complexity Is Bad

Anything that slows building and testing the software is bad. Anything that makes builds less reliable is bad.

## Frontend Complexity Is Bad

Frontend complexity affects all the other principles: operational cosst and build complexity. The architecture must
avoid becoming mired in frontend complexity, even when this means giving up common patterns or solutions.

## Operational Cost Is Bad

I aim to squeeze into DigitalOcean's smallest VPS (1 VCPU, 512Mb RAM, $4/mth).

## Mobile UIs Come First

Most users will view the site on their phones, fewer on the desktop.

## Play Is OK

It is acceptable to go off the beaten track to try technologies and tools.
