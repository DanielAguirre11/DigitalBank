package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.AccountHolder;
import com.banco.infrastructure.persistence.entities.AccountHolderEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountHolderMapper {

    // ENTITY → DOMINIO
    public AccountHolder aDominio(AccountHolderEntity entity) {
        return new AccountHolder(
            entity.getHolderId(),
            entity.getAccountId(),
            entity.getCustomerId(),
            entity.getHolderType(),
            entity.getOwnershipPercentage(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.isActive()
        );
    }

    // DOMINIO → ENTITY
    public AccountHolderEntity aEntity(AccountHolder dominio, AccountHolderEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new AccountHolderEntity();
        }

        entityExistente.setAccountId(dominio.getAccountId());
        entityExistente.setCustomerId(dominio.getCustomerId());
        entityExistente.setHolderType(dominio.getHolderType());
        entityExistente.setOwnershipPercentage(dominio.getOwnershipPercentage());
        entityExistente.setStartDate(dominio.getStartDate());
        entityExistente.setEndDate(dominio.getEndDate());
        entityExistente.setActive(dominio.isActive());

        return entityExistente;
    }
}
