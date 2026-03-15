package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.HolderType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "account_holder", schema = "accounts")
public class AccountHolderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "holder_id")
    private UUID holderId;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "holder_type", nullable = false, length = 30)
    private HolderType holderType;

    @Column(name = "ownership_percentage", precision = 5, scale = 2)
    private BigDecimal ownershipPercentage;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "active", nullable = false)
    private boolean active;


    // Default constructor required by JPA
    public AccountHolderEntity() {}

    // All-args constructor
    public AccountHolderEntity(UUID holderId, UUID accountId, UUID customerId,
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


    // Getters & Setters
    public UUID getHolderId() { return holderId; }
    public void setHolderId(UUID holderId) { this.holderId = holderId; }

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public UUID getCustomerId() { return customerId; }
    public void setCustomerId(UUID customerId) { this.customerId = customerId; }

    public HolderType getHolderType() { return holderType; }
    public void setHolderType(HolderType holderType) { this.holderType = holderType; }

    public BigDecimal getOwnershipPercentage() { return ownershipPercentage; }
    public void setOwnershipPercentage(BigDecimal ownershipPercentage) { this.ownershipPercentage = ownershipPercentage; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
