package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.PartnerLocation;
import com.banco.infrastructure.persistence.entities.PartnerLocationEntity;
import org.springframework.stereotype.Component;

@Component
public class PartnerLocationMapper {

    // ENTITY → DOMINIO
    public PartnerLocation aDominio(PartnerLocationEntity entity) {
        return new PartnerLocation(
            entity.getPartnerLocationId(),
            entity.getPartnerId(),
            entity.getPartnerLocationType(),
            entity.getCountryCode(),
            entity.getStateProvince(),
            entity.getCity(),
            entity.getAddressLine1(),
            entity.getAddressLine2(),
            entity.getPostalCode(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    // DOMINIO → ENTITY
    public PartnerLocationEntity aEntity(PartnerLocation dominio, PartnerLocationEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new PartnerLocationEntity();
        }

        entityExistente.setPartnerId(dominio.getPartnerId());
        entityExistente.setPartnerLocationType(dominio.getPartnerLocationType());
        entityExistente.setCountryCode(dominio.getCountryCode());
        entityExistente.setStateProvince(dominio.getStateProvince());
        entityExistente.setCity(dominio.getCity());
        entityExistente.setAddressLine1(dominio.getAddressLine1());
        entityExistente.setAddressLine2(dominio.getAddressLine2());
        entityExistente.setPostalCode(dominio.getPostalCode());

        return entityExistente;
    }
}
