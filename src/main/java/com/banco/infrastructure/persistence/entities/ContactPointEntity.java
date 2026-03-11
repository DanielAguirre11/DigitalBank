package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.ContactPointType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_point")
public class ContactPointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_point_id")
    private Long contactPointId;

    @Column(name = "party_id", nullable = false)
    private Integer partyId;

    // Converter autoApply = true maneja la conversion al valor del enum de BD
    @Column(name = "contact_point_type", nullable = false, length = 50)
    private ContactPointType contactPointType;

    @Column(name = "contact_value", nullable = false, columnDefinition = "TEXT")
    private String contactValue;

    @Column(name = "is_primary")
    private boolean isPrimary;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    // CONSTRUCTOR VACIO requerido por JPA
    public ContactPointEntity() {}


    // GETTERS & SETTERS
    public Long getContactPointId() { return contactPointId; }
    public void setContactPointId(Long contactPointId) { this.contactPointId = contactPointId; }

    public Integer getPartyId() { return partyId; }
    public void setPartyId(Integer partyId) { this.partyId = partyId; }

    public ContactPointType getContactPointType() { return contactPointType; }
    public void setContactPointType(ContactPointType contactPointType) { this.contactPointType = contactPointType; }

    public String getContactValue() { return contactValue; }
    public void setContactValue(String contactValue) { this.contactValue = contactValue; }

    public boolean isPrimary() { return isPrimary; }
    public void setPrimary(boolean isPrimary) { this.isPrimary = isPrimary; }

    public LocalDate getValidFrom() { return validFrom; }
    public void setValidFrom(LocalDate validFrom) { this.validFrom = validFrom; }

    public LocalDate getValidTo() { return validTo; }
    public void setValidTo(LocalDate validTo) { this.validTo = validTo; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
