package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.TransactionCode;
import com.banco.infrastructure.persistence.entities.TransactionCodeEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionCodeMapper {

    // ENTITY → DOMINIO
    public TransactionCode aDominio(TransactionCodeEntity entity) {
        return new TransactionCode(
            entity.getTransactionCodeId(),
            entity.getCode(),
            entity.getName(),
            entity.getDescription(),
            entity.getCategory(),
            entity.getDefaultEntryType(),
            entity.getGlDebitAccountCode(),
            entity.getGlCreditAccountCode(),
            entity.getAllowedChannels(),
            entity.isRequiresAuthorization(),
            entity.isGeneratesTax(),
            entity.isGeneratesGlEntry(),
            entity.isReversible(),
            entity.isActive(),
            entity.getEffectiveDate(),
            entity.getExpiryDate()
        );
    }

    // DOMINIO → ENTITY
    public TransactionCodeEntity aEntity(TransactionCode dominio, TransactionCodeEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new TransactionCodeEntity();
        }

        entityExistente.setCode(dominio.getCode());
        entityExistente.setName(dominio.getName());
        entityExistente.setDescription(dominio.getDescription());
        entityExistente.setCategory(dominio.getCategory());
        entityExistente.setDefaultEntryType(dominio.getDefaultEntryType());
        entityExistente.setGlDebitAccountCode(dominio.getGlDebitAccountCode());
        entityExistente.setGlCreditAccountCode(dominio.getGlCreditAccountCode());
        entityExistente.setAllowedChannels(dominio.getAllowedChannels());
        entityExistente.setRequiresAuthorization(dominio.isRequiresAuthorization());
        entityExistente.setGeneratesTax(dominio.isGeneratesTax());
        entityExistente.setGeneratesGlEntry(dominio.isGeneratesGlEntry());
        entityExistente.setReversible(dominio.isReversible());
        entityExistente.setActive(dominio.isActive());
        entityExistente.setEffectiveDate(dominio.getEffectiveDate());
        entityExistente.setExpiryDate(dominio.getExpiryDate());

        return entityExistente;
    }
}
