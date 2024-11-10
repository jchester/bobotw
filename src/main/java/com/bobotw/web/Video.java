package com.bobotw.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("videos_with_win_ratios")
public record Video(@Id Long id, String title, String episodeTitle, Double winRatio) {
}

