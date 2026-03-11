package com.banco.application.dto;

import com.banco.domain.model.valueobjects.PartnerLocationType;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public class ActualizarPartnerLocationRequest {

    private PartnerLocationType partnerLocationType;

    @Size(max = 2)
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
    public ActualizarPartnerLocationRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<PartnerLocationType> getPartnerLocationType() { return Optional.ofNullable(partnerLocationType); }
    public void setPartnerLocationType(PartnerLocationType partnerLocationType) { this.partnerLocationType = partnerLocationType; }

    public Optional<String> getCountryCode() { return Optional.ofNullable(countryCode); }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public Optional<String> getStateProvince() { return Optional.ofNullable(stateProvince); }
    public void setStateProvince(String stateProvince) { this.stateProvince = stateProvince; }

    public Optional<String> getCity() { return Optional.ofNullable(city); }
    public void setCity(String city) { this.city = city; }

    public Optional<String> getAddressLine1() { return Optional.ofNullable(addressLine1); }
    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public Optional<String> getAddressLine2() { return Optional.ofNullable(addressLine2); }
    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public Optional<String> getPostalCode() { return Optional.ofNullable(postalCode); }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
}
