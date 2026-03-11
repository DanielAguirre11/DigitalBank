package com.banco.infrastructure.persistence.converters;

import com.banco.domain.model.valueobjects.PoliticalExposureType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PoliticalExposureTypeConverter implements AttributeConverter<PoliticalExposureType, String> {

    @Override
    public String convertToDatabaseColumn(PoliticalExposureType attribute) {
        return attribute == null ? null : attribute.getValor();
    }

    @Override
    public PoliticalExposureType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : PoliticalExposureType.fromValor(dbData);
    }
}
