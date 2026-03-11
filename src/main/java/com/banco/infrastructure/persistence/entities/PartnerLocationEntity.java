package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.PartnerLocationType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "partner_location")
public class PartnerLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_location_id")
    private Long partnerLocationId;

    @Column(name = "partner_id", nullable = false)
    private Long partnerId;

    // Converter autoApply = true maneja la conversion al valor del enum de BD
    @Column(name = "partner_location_type", nullable = false, length = 50)
    private PartnerLocationType partnerLocationType;

    @Column(name = "country_code", length = 2)
    private String countryCode;

    @Column(name = "state_province", length = 100)
    private String stateProvince;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "address_line1", length = 255)
    private String addressLine1;

    @Column(name = "address_line2", length = 255)
    private String addressLine2;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    // CONSTRUCTOR VACIO requerido por JPA
    public PartnerLocationEntity() {}


    // GETTERS & SETTERS
    public Long getPartnerLocationId() { return partnerLocationId; }
    public void setPartnerLocationId(Long partnerLocationId) { this.partnerLocationId = partnerLocationId; }

    public Long getPartnerId() { return partnerId; }
    public void setPartnerId(Long partnerId) { this.partnerId = partnerId; }

    public PartnerLocationType getPartnerLocationType() { return partnerLocationType; }
    public void setPartnerLocationType(PartnerLocationType partnerLocationType) { this.partnerLocationType = partnerLocationType; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getStateProvince() { return stateProvince; }
    public void setStateProvince(String stateProvince) { this.stateProvince = stateProvince; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddressLine1() { return addressLine1; }
    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public String getAddressLine2() { return addressLine2; }
    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
