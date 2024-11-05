package com.comparsas.unpapo.repository;

import com.comparsas.unpapo.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepository extends JpaRepository<Likes,UUID> {
}
