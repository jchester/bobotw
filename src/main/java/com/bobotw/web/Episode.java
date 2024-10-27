package com.bobotw.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("EPISODES")
public record Episode(@Id Long id, String title) {}