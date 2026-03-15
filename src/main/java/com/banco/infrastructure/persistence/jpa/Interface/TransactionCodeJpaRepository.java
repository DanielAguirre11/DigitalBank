package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.TransactionCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionCodeJpaRepository extends JpaRepository<TransactionCodeEntity, Short> {

    Optional<TransactionCodeEntity> findByCode(String code);

    boolean existsByCode(String code);

    boolean existsByCodeAndTransactionCodeIdNot(String code, Short transactionCodeId);
}
