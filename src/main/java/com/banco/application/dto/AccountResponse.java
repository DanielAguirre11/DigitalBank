package com.banco.application.dto;

import com.banco.domain.model.valueobjects.AccountStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class AccountResponse {

    private UUID accountId;
    private String accountNumber;
    private Integer productId;
    private UUID customerId;
    private String currencyId;
    private BigDecimal availableBalance;
    private BigDecimal ledgerBalance;
    private BigDecimal heldBalance;
    private AccountStatus status;
    private LocalDate openDate;
    private LocalDate closeDate;
    private Integer branchId;
    private UUID accountOfficerId;
    private boolean overdraftAllowed;
    private BigDecimal overdraftLimit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR
    public AccountResponse(UUID accountId, String accountNumber, Integer productId, UUID customerId,
                           String currencyId, BigDecimal availableBalance, BigDecimal ledgerBalance,
                           BigDecimal heldBalance, AccountStatus status, LocalDate openDate,
                           LocalDate closeDate, Integer branchId, UUID accountOfficerId,
                           boolean overdraftAllowed, BigDecimal overdraftLimit,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.productId = productId;
        this.customerId = customerId;
        this.currencyId = currencyId;
        this.availableBalance = availableBalance;
        this.ledgerBalance = ledgerBalance;
        this.heldBalance = heldBalance;
        this.status = status;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.branchId = branchId;
        this.accountOfficerId = accountOfficerId;
        this.overdraftAllowed = overdraftAllowed;
        this.overdraftLimit = overdraftLimit;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    // GETTERS
    public UUID getAccountId() { return accountId; }
    public String getAccountNumber() { return accountNumber; }
    public Integer getProductId() { return productId; }
    public UUID getCustomerId() { return customerId; }
    public String getCurrencyId() { return currencyId; }
    public BigDecimal getAvailableBalance() { return availableBalance; }
    public BigDecimal getLedgerBalance() { return ledgerBalance; }
    public BigDecimal getHeldBalance() { return heldBalance; }
    public AccountStatus getStatus() { return status; }
    public LocalDate getOpenDate() { return openDate; }
    public LocalDate getCloseDate() { return closeDate; }
    public Integer getBranchId() { return branchId; }
    public UUID getAccountOfficerId() { return accountOfficerId; }
    public boolean isOverdraftAllowed() { return overdraftAllowed; }
    public BigDecimal getOverdraftLimit() { return overdraftLimit; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
