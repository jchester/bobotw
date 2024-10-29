package com.bobotw.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("PAIR_RANKINGS")
public record PairRanking(@Id Long id, UUID rankerId, Long winnerId, Long loserId) {
}

