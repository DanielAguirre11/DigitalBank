package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.ProductFamily;
import com.banco.infrastructure.persistence.entities.ProductFamilyEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductFamilyMapper {

    // ENTITY -> DOMINIO
    public ProductFamily aDominio(ProductFamilyEntity entity) {
        return new ProductFamily(
            entity.getFamilyId(),
            entity.getCode(),
            entity.getName(),
            entity.getDescription(),
            entity.isActive()
        );
    }

    // DOMINIO -> ENTITY
    public ProductFamilyEntity aEntity(ProductFamily dominio, ProductFamilyEntity entityExistente) {
        if (entityExistente == null) {
            entityExistente = new ProductFamilyEntity();
        }

        entityExistente.setCode(dominio.getCode());
        entityExistente.setName(dominio.getName());
        entityExistente.setDescription(dominio.getDescription());
        entityExistente.setActive(dominio.isActive());

        return entityExistente;
    }
}
