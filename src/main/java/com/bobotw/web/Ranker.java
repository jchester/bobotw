package com.bobotw.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("rankers")
public record Ranker(@Id UUID id) {
}
