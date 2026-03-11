package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.ContactPointType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class ContactPoint {

    private Long contactPointId;
    private final Integer partyId;
    private final ContactPointType contactPointType;
    private String contactValue;
    private boolean isPrimary;
    private LocalDate validFrom;
    private LocalDate validTo;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR PARA CREAR
    public ContactPoint(Integer partyId, ContactPointType contactPointType, String contactValue,
                        boolean isPrimary, LocalDate validFrom, LocalDate validTo) {
        this.partyId = partyId;
        this.contactPointType = Objects.requireNonNull(contactPointType, "El tipo de punto de contacto no puede ser nulo");
        this.contactValue = Objects.requireNonNull(contactValue, "El valor de contacto no puede ser nulo");
        this.isPrimary = isPrimary;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // CONSTRUCTOR PARA RECONSTRUIR DESDE BD
    public ContactPoint(Long contactPointId, Integer partyId, ContactPointType contactPointType,
                        String contactValue, boolean isPrimary, LocalDate validFrom, LocalDate validTo,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.contactPointId = contactPointId;
        this.partyId = partyId;
        this.contactPointType = Objects.requireNonNull(contactPointType, "El tipo de punto de contacto no puede ser nulo");
        this.contactValue = Objects.requireNonNull(contactValue, "El valor de contacto no puede ser nulo");
        this.isPrimary = isPrimary;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // GETTERS
    public Long getContactPointId() { return contactPointId; }
    public Integer getPartyId() { return partyId; }
    public ContactPointType getContactPointType() { return contactPointType; }
    public String getContactValue() { return contactValue; }
    public boolean isPrimary() { return isPrimary; }
    public LocalDate getValidFrom() { return validFrom; }
    public LocalDate getValidTo() { return validTo; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // SETTERS
    public void setContactPointId(Long contactPointId) { this.contactPointId = contactPointId; }
    public void setContactValue(String contactValue) { this.contactValue = Objects.requireNonNull(contactValue); }
    public void setPrimary(boolean primary) { this.isPrimary = primary; }
    public void setValidFrom(LocalDate validFrom) { this.validFrom = validFrom; }
    public void setValidTo(LocalDate validTo) { this.validTo = validTo; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
