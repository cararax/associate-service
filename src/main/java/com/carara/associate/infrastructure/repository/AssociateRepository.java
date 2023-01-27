package com.carara.associate.infrastructure.repository;

import com.carara.associate.domain.entity.Associate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociateRepository extends JpaRepository<Associate, Long> {
}