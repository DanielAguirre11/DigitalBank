package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.Account;
import com.banco.infrastructure.persistence.entities.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    // ENTITY → DOMINIO
    public Account aDominio(AccountEntity entity) {
        return new Account(
            entity.getAccountId(),
            entity.getAccountNumber(),
            entity.getProductId(),
            entity.getCustomerId(),
            entity.getCurrencyId(),
            entity.getAvailableBalance(),
            entity.getLedgerBalance(),
            entity.getHeldBalance(),
            entity.getStatus(),
            entity.getOpenDate(),
            entity.getCloseDate(),
            entity.getBranchId(),
            entity.getAccountOfficerId(),
            entity.isOverdraftAllowed(),
            entity.getOverdraftLimit(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    // DOMINIO → ENTITY
    public AccountEntity aEntity(Account dominio, AccountEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new AccountEntity();
        }

        entityExistente.setAccountNumber(dominio.getAccountNumber());
        entityExistente.setProductId(dominio.getProductId());
        entityExistente.setCustomerId(dominio.getCustomerId());
        entityExistente.setCurrencyId(dominio.getCurrencyId());
        entityExistente.setAvailableBalance(dominio.getAvailableBalance());
        entityExistente.setLedgerBalance(dominio.getLedgerBalance());
        entityExistente.setHeldBalance(dominio.getHeldBalance());
        entityExistente.setStatus(dominio.getStatus());
        entityExistente.setOpenDate(dominio.getOpenDate());
        entityExistente.setCloseDate(dominio.getCloseDate());
        entityExistente.setBranchId(dominio.getBranchId());
        entityExistente.setAccountOfficerId(dominio.getAccountOfficerId());
        entityExistente.setOverdraftAllowed(dominio.isOverdraftAllowed());
        entityExistente.setOverdraftLimit(dominio.getOverdraftLimit());

        return entityExistente;
    }
}
