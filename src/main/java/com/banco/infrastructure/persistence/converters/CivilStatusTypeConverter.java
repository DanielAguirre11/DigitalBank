package com.banco.infrastructure.persistence.converters;

import com.banco.domain.model.valueobjects.CivilStatusType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CivilStatusTypeConverter implements AttributeConverter<CivilStatusType, String> {

    @Override
    public String convertToDatabaseColumn(CivilStatusType attribute) {
        return attribute == null ? null : attribute.getValor();
    }

    @Override
    public CivilStatusType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : CivilStatusType.fromValor(dbData);
    }
}
