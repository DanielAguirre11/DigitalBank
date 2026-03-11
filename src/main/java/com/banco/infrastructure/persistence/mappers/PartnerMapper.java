package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.Partner;
import com.banco.infrastructure.persistence.entities.PartnerEntity;
import org.springframework.stereotype.Component;

@Component
public class PartnerMapper {

    // ENTITY → DOMINIO
    public Partner aDominio(PartnerEntity entity) {
        return new Partner(
            entity.getPartnerId(),
            entity.getIdentificationType(),
            entity.getIdentificationValue(),
            entity.getFirstName(),
            entity.getMiddleName(),
            entity.getLastName(),
            entity.getBirthDate(),
            entity.getNationality(),
            entity.getResidentialStatus(),
            entity.getEthnicity(),
            entity.getReligion(),
            entity.getCivilStatus(),
            entity.getJobTitle(),
            entity.getNamePrefix(),
            entity.isState(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    // DOMINIO → ENTITY
    public PartnerEntity aEntity(Partner dominio, PartnerEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new PartnerEntity();
        }

        entityExistente.setIdentificationType(dominio.getIdentificationType());
        entityExistente.setIdentificationValue(dominio.getIdentificationValue());
        entityExistente.setFirstName(dominio.getFirstName());
        entityExistente.setMiddleName(dominio.getMiddleName());
        entityExistente.setLastName(dominio.getLastName());
        entityExistente.setBirthDate(dominio.getBirthDate());
        entityExistente.setNationality(dominio.getNationality());
        entityExistente.setResidentialStatus(dominio.getResidentialStatus());
        entityExistente.setEthnicity(dominio.getEthnicity());
        entityExistente.setReligion(dominio.getReligion());
        entityExistente.setCivilStatus(dominio.getCivilStatus());
        entityExistente.setJobTitle(dominio.getJobTitle());
        entityExistente.setNamePrefix(dominio.getNamePrefix());
        entityExistente.setState(dominio.isState());

        return entityExistente;
    }
}
