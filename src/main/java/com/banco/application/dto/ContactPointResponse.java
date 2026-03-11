package com.banco.application.dto;

import com.banco.domain.model.valueobjects.ContactPointType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContactPointResponse {

    private Long contactPointId;
    private Integer partyId;
    private ContactPointType contactPointType;
    private String contactValue;
    private boolean primary;
    private LocalDate validFrom;
    private LocalDate validTo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR
    public ContactPointResponse(Long contactPointId, Integer partyId, ContactPointType contactPointType,
                                String contactValue, boolean primary, LocalDate validFrom, LocalDate validTo,
                                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.contactPointId = contactPointId;
        this.partyId = partyId;
        this.contactPointType = contactPointType;
        this.contactValue = contactValue;
        this.primary = primary;
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
    public boolean isPrimary() { return primary; }
    public LocalDate getValidFrom() { return validFrom; }
    public LocalDate getValidTo() { return validTo; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
