package com.comparsas.unpapo.repository;

import com.comparsas.unpapo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
