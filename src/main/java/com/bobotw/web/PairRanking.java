package com.bobotw.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("pair_rankings")
public record PairRanking(@Id Long id, UUID rankerId, Long winnerId, Long loserId) {
}

