package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.PartnerLocationType;

import java.time.LocalDateTime;
import java.util.Objects;

public class PartnerLocation {

    private Long partnerLocationId;
    private final Long partnerId;
    private PartnerLocationType partnerLocationType;
    private String countryCode;
    private String stateProvince;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR PARA CREAR
    public PartnerLocation(Long partnerId, PartnerLocationType partnerLocationType,
                           String countryCode, String stateProvince, String city,
                           String addressLine1, String addressLine2, String postalCode) {
        this.partnerId = Objects.requireNonNull(partnerId, "El partnerId no puede ser nulo");
        this.partnerLocationType = Objects.requireNonNull(partnerLocationType, "El tipo de ubicacion no puede ser nulo");
        this.countryCode = countryCode;
        this.stateProvince = stateProvince;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postalCode = postalCode;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // CONSTRUCTOR PARA RECONSTRUIR DESDE BD
    public PartnerLocation(Long partnerLocationId, Long partnerId, PartnerLocationType partnerLocationType,
                           String countryCode, String stateProvince, String city,
                           String addressLine1, String addressLine2, String postalCode,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.partnerLocationId = partnerLocationId;
        this.partnerId = Objects.requireNonNull(partnerId, "El partnerId no puede ser nulo");
        this.partnerLocationType = Objects.requireNonNull(partnerLocationType, "El tipo de ubicacion no puede ser nulo");
        this.countryCode = countryCode;
        this.stateProvince = stateProvince;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postalCode = postalCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // GETTERS
    public Long getPartnerLocationId() { return partnerLocationId; }
    public Long getPartnerId() { return partnerId; }
    public PartnerLocationType getPartnerLocationType() { return partnerLocationType; }
    public String getCountryCode() { return countryCode; }
    public String getStateProvince() { return stateProvince; }
    public String getCity() { return city; }
    public String getAddressLine1() { return addressLine1; }
    public String getAddressLine2() { return addressLine2; }
    public String getPostalCode() { return postalCode; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // SETTERS
    public void setPartnerLocationId(Long partnerLocationId) { this.partnerLocationId = partnerLocationId; }
    public void setPartnerLocationType(PartnerLocationType partnerLocationType) { this.partnerLocationType = partnerLocationType; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public void setStateProvince(String stateProvince) { this.stateProvince = stateProvince; }
    public void setCity(String city) { this.city = city; }
    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }
    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
