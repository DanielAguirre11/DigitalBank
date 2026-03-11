package com.banco.application.dto;

import com.banco.domain.model.valueobjects.PartnerLocationType;

import java.time.LocalDateTime;

public class PartnerLocationResponse {

    private Long partnerLocationId;
    private Long partnerId;
    private PartnerLocationType partnerLocationType;
    private String countryCode;
    private String stateProvince;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR
    public PartnerLocationResponse(Long partnerLocationId, Long partnerId,
                                   PartnerLocationType partnerLocationType, String countryCode,
                                   String stateProvince, String city, String addressLine1,
                                   String addressLine2, String postalCode,
                                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.partnerLocationId = partnerLocationId;
        this.partnerId = partnerId;
        this.partnerLocationType = partnerLocationType;
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
}
