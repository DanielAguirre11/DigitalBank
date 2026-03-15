package com.banco.application.dto;

import com.banco.domain.model.valueobjects.HolderType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class ActualizarAccountHolderRequest {

    private HolderType holderType;
    private BigDecimal ownershipPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;

    // Default constructor
    public ActualizarAccountHolderRequest() {}

    // Getters returning Optional
    public Optional<HolderType> getHolderType() { return Optional.ofNullable(holderType); }
    public Optional<BigDecimal> getOwnershipPercentage() { return Optional.ofNullable(ownershipPercentage); }
    public Optional<LocalDate> getStartDate() { return Optional.ofNullable(startDate); }
    public Optional<LocalDate> getEndDate() { return Optional.ofNullable(endDate); }
    public Optional<Boolean> getActive() { return Optional.ofNullable(active); }

    // Setters (store raw value)
    public void setHolderType(HolderType holderType) { this.holderType = holderType; }
    public void setOwnershipPercentage(BigDecimal ownershipPercentage) { this.ownershipPercentage = ownershipPercentage; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setActive(Boolean active) { this.active = active; }
}
