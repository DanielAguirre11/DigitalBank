package com.banco.application.dto;

import com.banco.domain.model.valueobjects.HolderType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class AccountHolderResponse {

    private final UUID holderId;
    private final UUID accountId;
    private final UUID customerId;
    private final HolderType holderType;
    private final BigDecimal ownershipPercentage;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final boolean active;

    public AccountHolderResponse(UUID holderId, UUID accountId, UUID customerId,
                                  HolderType holderType, BigDecimal ownershipPercentage,
                                  LocalDate startDate, LocalDate endDate, boolean active) {
        this.holderId = holderId;
        this.accountId = accountId;
        this.customerId = customerId;
        this.holderType = holderType;
        this.ownershipPercentage = ownershipPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    // Getters only
    public UUID getHolderId() { return holderId; }
    public UUID getAccountId() { return accountId; }
    public UUID getCustomerId() { return customerId; }
    public HolderType getHolderType() { return holderType; }
    public BigDecimal getOwnershipPercentage() { return ownershipPercentage; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isActive() { return active; }
}
