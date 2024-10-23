package com.bobotw;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "pair_rankings")
public class PairRanking {
    @Id
    private Long id;

    @Column(name = "winner_id")
    private Long winnerId;

    @Column(name = "loser_id")
    private Long loserId;

    @Column(name = "ranker_id")
    private UUID rankerId;
}
