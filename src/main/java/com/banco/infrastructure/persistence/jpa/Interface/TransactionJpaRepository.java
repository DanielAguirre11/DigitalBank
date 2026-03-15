package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {

    List<TransactionEntity> findByAccountIdOrderByTransactionDateDesc(UUID accountId);
}
