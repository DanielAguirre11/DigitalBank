package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.Transaction;
import com.banco.infrastructure.persistence.entities.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    // ENTITY → DOMINIO
    public Transaction aDominio(TransactionEntity entity) {
        return new Transaction(
            entity.getTransactionId(),
            entity.getAccountId(),
            entity.getTransactionDate(),
            entity.getValueDate(),
            entity.getTransactionType(),
            entity.getTransactionCodeId(),
            entity.getAmount(),
            entity.getBalanceBefore(),
            entity.getBalanceAfter(),
            entity.getExternalReference(),
            entity.getChannel(),
            entity.getUserId(),
            entity.isReversed(),
            entity.getOriginalTxnId()
        );
    }

    // DOMINIO → ENTITY
    public TransactionEntity aEntity(Transaction dominio, TransactionEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new TransactionEntity();
        }

        entityExistente.setAccountId(dominio.getAccountId());
        entityExistente.setValueDate(dominio.getValueDate());
        entityExistente.setTransactionType(dominio.getTransactionType());
        entityExistente.setTransactionCodeId(dominio.getTransactionCodeId());
        entityExistente.setAmount(dominio.getAmount());
        entityExistente.setBalanceBefore(dominio.getBalanceBefore());
        entityExistente.setBalanceAfter(dominio.getBalanceAfter());
        entityExistente.setExternalReference(dominio.getExternalReference());
        entityExistente.setChannel(dominio.getChannel());
        entityExistente.setUserId(dominio.getUserId());
        entityExistente.setReversed(dominio.isReversed());
        entityExistente.setOriginalTxnId(dominio.getOriginalTxnId());

        return entityExistente;
    }
}
