package com.banco.infrastructure.persistence.converters;

import com.banco.domain.model.valueobjects.PartnerIdentificationType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PartnerIdentificationTypeConverter implements AttributeConverter<PartnerIdentificationType, String> {

    @Override
    public String convertToDatabaseColumn(PartnerIdentificationType attribute) {
        return attribute == null ? null : attribute.getValor();
    }

    @Override
    public PartnerIdentificationType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : PartnerIdentificationType.fromValor(dbData);
    }
}
