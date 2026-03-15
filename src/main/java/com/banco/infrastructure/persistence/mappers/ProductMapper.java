package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.Product;
import com.banco.infrastructure.persistence.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // ENTITY -> DOMINIO
    public Product aDominio(ProductEntity entity) {
        return new Product(
            entity.getProductId(),
            entity.getFamilyId(),
            entity.getCode(),
            entity.getName(),
            entity.getDescription(),
            entity.getProductType(),
            entity.getCurrencyId(),
            entity.getBaseInterestRate(),
            entity.getMaxInterestRate(),
            entity.getMinInterestRate(),
            entity.getMinTermDays(),
            entity.getMaxTermDays(),
            entity.getMinAmount(),
            entity.getMaxAmount(),
            entity.isRequiresCollateral(),
            entity.isTaxApplicable(),
            entity.getStatus(),
            entity.getEffectiveDate(),
            entity.getExpiryDate(),
            entity.getCreatedAt()
        );
    }

    // DOMINIO -> ENTITY
    public ProductEntity aEntity(Product dominio, ProductEntity entityExistente) {
        if (entityExistente == null) {
            entityExistente = new ProductEntity();
        }

        entityExistente.setFamilyId(dominio.getFamilyId());
        entityExistente.setCode(dominio.getCode());
        entityExistente.setName(dominio.getName());
        entityExistente.setDescription(dominio.getDescription());
        entityExistente.setProductType(dominio.getProductType());
        entityExistente.setCurrencyId(dominio.getCurrencyId());
        entityExistente.setBaseInterestRate(dominio.getBaseInterestRate());
        entityExistente.setMaxInterestRate(dominio.getMaxInterestRate());
        entityExistente.setMinInterestRate(dominio.getMinInterestRate());
        entityExistente.setMinTermDays(dominio.getMinTermDays());
        entityExistente.setMaxTermDays(dominio.getMaxTermDays());
        entityExistente.setMinAmount(dominio.getMinAmount());
        entityExistente.setMaxAmount(dominio.getMaxAmount());
        entityExistente.setRequiresCollateral(dominio.isRequiresCollateral());
        entityExistente.setTaxApplicable(dominio.isTaxApplicable());
        entityExistente.setStatus(dominio.getStatus());
        entityExistente.setEffectiveDate(dominio.getEffectiveDate());
        entityExistente.setExpiryDate(dominio.getExpiryDate());

        return entityExistente;
    }
}
