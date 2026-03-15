package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.HolderType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class AccountHolder {

    private UUID holderId;
    private final UUID accountId;
    private final UUID customerId;
    private HolderType holderType;
    private BigDecimal ownershipPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    // Constructor for create (no holderId — assigned after save)
    public AccountHolder(UUID accountId, UUID customerId, HolderType holderType,
                         BigDecimal ownershipPercentage, LocalDate startDate,
                         LocalDate endDate, boolean active) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.holderType = holderType;
        this.ownershipPercentage = ownershipPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    // Constructor for reconstruct from DB (all fields)
    public AccountHolder(UUID holderId, UUID accountId, UUID customerId, HolderType holderType,
                         BigDecimal ownershipPercentage, LocalDate startDate,
                         LocalDate endDate, boolean active) {
        this.holderId = holderId;
        this.accountId = accountId;
        this.customerId = customerId;
        this.holderType = holderType;
        this.ownershipPercentage = ownershipPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    // Getters
    public UUID getHolderId() { return holderId; }
    public UUID getAccountId() { return accountId; }
    public UUID getCustomerId() { return customerId; }
    public HolderType getHolderType() { return holderType; }
    public BigDecimal getOwnershipPercentage() { return ownershipPercentage; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isActive() { return active; }

    // Setters (mutable fields)
    public void setHolderId(UUID holderId) { this.holderId = holderId; }
    public void setHolderType(HolderType holderType) { this.holderType = holderType; }
    public void setOwnershipPercentage(BigDecimal ownershipPercentage) { this.ownershipPercentage = ownershipPercentage; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setActive(boolean active) { this.active = active; }
}
