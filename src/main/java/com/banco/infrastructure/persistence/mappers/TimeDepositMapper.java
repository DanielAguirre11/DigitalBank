package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.TimeDeposit;
import com.banco.infrastructure.persistence.entities.TimeDepositEntity;
import org.springframework.stereotype.Component;

@Component
public class TimeDepositMapper {

    // ENTITY → DOMINIO
    public TimeDeposit aDominio(TimeDepositEntity entity) {
        return new TimeDeposit(
            entity.getDepositId(),
            entity.getAccountId(),
            entity.getOriginalAmount(),
            entity.getAgreedRate(),
            entity.getStartDate(),
            entity.getMaturityDate(),
            entity.getTermDays(),
            entity.getRenewalMode(),
            entity.isCapitalizeInterest(),
            entity.getStatus(),
            entity.getAccruedInterest()
        );
    }

    // DOMINIO → ENTITY
    public TimeDepositEntity aEntity(TimeDeposit dominio, TimeDepositEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new TimeDepositEntity();
        }

        entityExistente.setAccountId(dominio.getAccountId());
        entityExistente.setOriginalAmount(dominio.getOriginalAmount());
        entityExistente.setAgreedRate(dominio.getAgreedRate());
        entityExistente.setStartDate(dominio.getStartDate());
        entityExistente.setMaturityDate(dominio.getMaturityDate());
        entityExistente.setTermDays(dominio.getTermDays());
        entityExistente.setRenewalMode(dominio.getRenewalMode());
        entityExistente.setCapitalizeInterest(dominio.isCapitalizeInterest());
        entityExistente.setStatus(dominio.getStatus());
        entityExistente.setAccruedInterest(dominio.getAccruedInterest());

        return entityExistente;
    }
}
