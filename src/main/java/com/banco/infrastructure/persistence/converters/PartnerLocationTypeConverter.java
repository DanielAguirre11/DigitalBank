package com.banco.infrastructure.persistence.converters;

import com.banco.domain.model.valueobjects.PartnerLocationType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PartnerLocationTypeConverter implements AttributeConverter<PartnerLocationType, String> {

    @Override
    public String convertToDatabaseColumn(PartnerLocationType attribute) {
        return attribute == null ? null : attribute.getValor();
    }

    @Override
    public PartnerLocationType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : PartnerLocationType.fromValor(dbData);
    }
}
