package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.ContactPoint;
import com.banco.infrastructure.persistence.entities.ContactPointEntity;
import org.springframework.stereotype.Component;

@Component
public class ContactPointMapper {

    // ENTITY → DOMINIO
    public ContactPoint aDominio(ContactPointEntity entity) {
        return new ContactPoint(
            entity.getContactPointId(),
            entity.getPartyId(),
            entity.getContactPointType(),
            entity.getContactValue(),
            entity.isPrimary(),
            entity.getValidFrom(),
            entity.getValidTo(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    // DOMINIO → ENTITY
    public ContactPointEntity aEntity(ContactPoint dominio, ContactPointEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new ContactPointEntity();
        }

        entityExistente.setPartyId(dominio.getPartyId());
        entityExistente.setContactPointType(dominio.getContactPointType());
        entityExistente.setContactValue(dominio.getContactValue());
        entityExistente.setPrimary(dominio.isPrimary());
        entityExistente.setValidFrom(dominio.getValidFrom());
        entityExistente.setValidTo(dominio.getValidTo());

        return entityExistente;
    }
}
