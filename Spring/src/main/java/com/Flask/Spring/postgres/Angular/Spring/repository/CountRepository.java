package com.Flask.Spring.postgres.Angular.Spring.repository;

import com.Flask.Spring.postgres.Angular.Spring.entity.Count;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountRepository extends JpaRepository<Count, Long> {
}
