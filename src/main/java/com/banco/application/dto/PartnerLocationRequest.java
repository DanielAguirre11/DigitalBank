package com.banco.application.dto;

import com.banco.domain.model.valueobjects.PartnerLocationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PartnerLocationRequest {

    @NotNull(message = "El id del partner es obligatorio")
    private Long partnerId;

    @NotNull(message = "El tipo de ubicacion es obligatorio")
    private PartnerLocationType partnerLocationType;

    @Size(max = 2, message = "El codigo de pais debe ser de 2 caracteres")
    private String countryCode;

    @Size(max = 100)
    private String stateProvince;

    @Size(max = 100)
    private String city;

    @Size(max = 255)
    private String addressLine1;

    @Size(max = 255)
    private String addressLine2;

    @Size(max = 20)
    private String postalCode;


    // CONSTRUCTORS
    public PartnerLocationRequest() {}

    public PartnerLocationRequest(Long partnerId, PartnerLocationType partnerLocationType,
                                  String countryCode, String stateProvince, String city,
                                  String addressLine1, String addressLine2, String postalCode) {
        this.partnerId = partnerId;
        this.partnerLocationType = partnerLocationType;
        this.countryCode = countryCode;
        this.stateProvince = stateProvince;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postalCode = postalCode;
    }


    // GETTERS & SETTERS
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
}
