package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.ProductFee;
import com.banco.infrastructure.persistence.entities.ProductFeeEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductFeeMapper {

    // ENTITY -> DOMINIO
    public ProductFee aDominio(ProductFeeEntity entity) {
        return new ProductFee(
            entity.getFeeId(),
            entity.getProductId(),
            entity.getFeeType(),
            entity.getCalculationMode(),
            entity.getValue(),
            entity.getCurrencyId(),
            entity.getFrequency(),
            entity.isVatApplicable(),
            entity.isActive()
        );
    }

    // DOMINIO -> ENTITY
    public ProductFeeEntity aEntity(ProductFee dominio, ProductFeeEntity entityExistente) {
        if (entityExistente == null) {
            entityExistente = new ProductFeeEntity();
        }

        entityExistente.setProductId(dominio.getProductId());
        entityExistente.setFeeType(dominio.getFeeType());
        entityExistente.setCalculationMode(dominio.getCalculationMode());
        entityExistente.setValue(dominio.getValue());
        entityExistente.setCurrencyId(dominio.getCurrencyId());
        entityExistente.setFrequency(dominio.getFrequency());
        entityExistente.setVatApplicable(dominio.isVatApplicable());
        entityExistente.setActive(dominio.isActive());

        return entityExistente;
    }
}
