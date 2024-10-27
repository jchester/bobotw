package com.bobotw.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PAIR_RANKINGS")
public record PairRanking(@Id Long id, Ranker ranker, Video winner, Video loser) {
}

