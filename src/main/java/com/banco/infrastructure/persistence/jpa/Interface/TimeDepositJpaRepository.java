package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.TimeDepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TimeDepositJpaRepository extends JpaRepository<TimeDepositEntity, UUID> {

    List<TimeDepositEntity> findByAccountId(UUID accountId);
}
