package com.banco.application.dto;

import com.banco.domain.model.valueobjects.HolderType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class AccountHolderRequest {

    @NotNull
    private UUID accountId;

    @NotNull
    private UUID customerId;

    @NotNull
    private HolderType holderType;

    private BigDecimal ownershipPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active = true;

    // Default constructor
    public AccountHolderRequest() {}

    // Getters
    public UUID getAccountId() { return accountId; }
    public UUID getCustomerId() { return customerId; }
    public HolderType getHolderType() { return holderType; }
    public BigDecimal getOwnershipPercentage() { return ownershipPercentage; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isActive() { return active; }

    // Setters
    public void setAccountId(UUID accountId) { this.accountId = accountId; }
    public void setCustomerId(UUID customerId) { this.customerId = customerId; }
    public void setHolderType(HolderType holderType) { this.holderType = holderType; }
    public void setOwnershipPercentage(BigDecimal ownershipPercentage) { this.ownershipPercentage = ownershipPercentage; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setActive(boolean active) { this.active = active; }
}
