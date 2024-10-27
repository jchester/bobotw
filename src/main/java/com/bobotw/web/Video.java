package com.bobotw.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("VIDEOS_WITH_WIN_RATIOS")
public record Video(@Id Long id, String title, Long episodeId, Double winRatio) {}

