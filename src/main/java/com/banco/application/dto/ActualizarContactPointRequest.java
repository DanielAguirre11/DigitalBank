package com.banco.application.dto;

import java.time.LocalDate;
import java.util.Optional;

public class ActualizarContactPointRequest {

    private String contactValue;

    private Boolean primary;

    private LocalDate validFrom;

    private LocalDate validTo;


    // CONSTRUCTORS
    public ActualizarContactPointRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<String> getContactValue() { return Optional.ofNullable(contactValue); }
    public void setContactValue(String contactValue) { this.contactValue = contactValue; }

    public Optional<Boolean> getPrimary() { return Optional.ofNullable(primary); }
    public void setPrimary(Boolean primary) { this.primary = primary; }

    public Optional<LocalDate> getValidFrom() { return Optional.ofNullable(validFrom); }
    public void setValidFrom(LocalDate validFrom) { this.validFrom = validFrom; }

    public Optional<LocalDate> getValidTo() { return Optional.ofNullable(validTo); }
    public void setValidTo(LocalDate validTo) { this.validTo = validTo; }
}
