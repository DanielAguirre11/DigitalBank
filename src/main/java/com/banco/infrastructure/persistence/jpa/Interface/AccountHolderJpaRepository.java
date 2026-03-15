package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.AccountHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountHolderJpaRepository extends JpaRepository<AccountHolderEntity, UUID> {

    List<AccountHolderEntity> findByAccountId(UUID accountId);

    List<AccountHolderEntity> findByCustomerId(UUID customerId);
}
