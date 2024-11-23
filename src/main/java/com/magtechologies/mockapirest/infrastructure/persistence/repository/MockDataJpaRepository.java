package com.magtechologies.mockapirest.infrastructure.persistence.repository;

import com.magtechologies.mockapirest.infrastructure.persistence.entity.MockDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockDataJpaRepository extends JpaRepository<MockDataEntity, Long> {
}