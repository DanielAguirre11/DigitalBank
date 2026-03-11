package com.banco.infrastructure.persistence.converters;

import com.banco.domain.model.valueobjects.ContactPointType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ContactPointTypeConverter implements AttributeConverter<ContactPointType, String> {

    @Override
    public String convertToDatabaseColumn(ContactPointType attribute) {
        return attribute == null ? null : attribute.getValor();
    }

    @Override
    public ContactPointType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : ContactPointType.fromValor(dbData);
    }
}
