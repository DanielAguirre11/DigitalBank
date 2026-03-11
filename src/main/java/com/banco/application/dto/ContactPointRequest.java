package com.banco.application.dto;

import com.banco.domain.model.valueobjects.ContactPointType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ContactPointRequest {

    @NotNull(message = "El id del party es obligatorio")
    private Integer partyId;

    @NotNull(message = "El tipo de punto de contacto es obligatorio")
    private ContactPointType contactPointType;

    @NotBlank(message = "El valor de contacto es obligatorio")
    private String contactValue;

    private boolean primary;

    private LocalDate validFrom;

    private LocalDate validTo;


    // CONSTRUCTORS
    public ContactPointRequest() {}

    public ContactPointRequest(Integer partyId, ContactPointType contactPointType, String contactValue,
                               boolean primary, LocalDate validFrom, LocalDate validTo) {
        this.partyId = partyId;
        this.contactPointType = contactPointType;
        this.contactValue = contactValue;
        this.primary = primary;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }


    // GETTERS & SETTERS
    public Integer getPartyId() { return partyId; }
    public void setPartyId(Integer partyId) { this.partyId = partyId; }

    public ContactPointType getContactPointType() { return contactPointType; }
    public void setContactPointType(ContactPointType contactPointType) { this.contactPointType = contactPointType; }

    public String getContactValue() { return contactValue; }
    public void setContactValue(String contactValue) { this.contactValue = contactValue; }

    public boolean isPrimary() { return primary; }
    public void setPrimary(boolean primary) { this.primary = primary; }

    public LocalDate getValidFrom() { return validFrom; }
    public void setValidFrom(LocalDate validFrom) { this.validFrom = validFrom; }

    public LocalDate getValidTo() { return validTo; }
    public void setValidTo(LocalDate validTo) { this.validTo = validTo; }
}
