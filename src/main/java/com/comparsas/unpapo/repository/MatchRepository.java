package com.comparsas.unpapo.repository;

import com.comparsas.unpapo.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
}