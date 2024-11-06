package com.bobotw.web;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PairRankingRepository extends CrudRepository<PairRanking, Long> {
    public Long countByRankerId(UUID ranker);
}
