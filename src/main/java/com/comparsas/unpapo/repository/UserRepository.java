package com.comparsas.unpapo.repository;

import com.comparsas.unpapo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
