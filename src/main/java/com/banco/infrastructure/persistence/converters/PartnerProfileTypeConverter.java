package com.banco.infrastructure.persistence.converters;

import com.banco.domain.model.valueobjects.PartnerProfileType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PartnerProfileTypeConverter implements AttributeConverter<PartnerProfileType, String> {

    @Override
    public String convertToDatabaseColumn(PartnerProfileType attribute) {
        return attribute == null ? null : attribute.getValor();
    }

    @Override
    public PartnerProfileType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : PartnerProfileType.fromValor(dbData);
    }
}
