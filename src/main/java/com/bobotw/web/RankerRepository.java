package com.bobotw.web;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RankerRepository extends CrudRepository<Ranker, UUID> {
}
