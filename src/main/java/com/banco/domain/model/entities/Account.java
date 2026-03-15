package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.AccountStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Account {

    private UUID accountId;
    private final String accountNumber;
    private final Integer productId;
    private final UUID customerId;
    private final String currencyId;
    private BigDecimal availableBalance;
    private BigDecimal ledgerBalance;
    private BigDecimal heldBalance;
    private AccountStatus status;
    private final LocalDate openDate;
    private LocalDate closeDate;
    private Integer branchId;
    private UUID accountOfficerId;
    private boolean overdraftAllowed;
    private BigDecimal overdraftLimit;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR PARA CREAR
    public Account(String accountNumber, Integer productId, UUID customerId, String currencyId,
                   AccountStatus status, LocalDate openDate, Integer branchId, UUID accountOfficerId,
                   boolean overdraftAllowed, BigDecimal overdraftLimit) {
        this.accountNumber = Objects.requireNonNull(accountNumber, "El numero de cuenta es obligatorio");
        this.productId = Objects.requireNonNull(productId, "El producto es obligatorio");
        this.customerId = Objects.requireNonNull(customerId, "El cliente es obligatorio");
        this.currencyId = Objects.requireNonNull(currencyId, "La moneda es obligatoria");
        this.availableBalance = BigDecimal.ZERO;
        this.ledgerBalance = BigDecimal.ZERO;
        this.heldBalance = BigDecimal.ZERO;
        this.status = status != null ? status : AccountStatus.ACTIVE;
        this.openDate = openDate != null ? openDate : LocalDate.now();
        this.branchId = branchId;
        this.accountOfficerId = accountOfficerId;
        this.overdraftAllowed = overdraftAllowed;
        this.overdraftLimit = overdraftLimit != null ? overdraftLimit : BigDecimal.ZERO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // CONSTRUCTOR PARA RECONSTRUIR DESDE BD
    public Account(UUID accountId, String accountNumber, Integer productId, UUID customerId,
                   String currencyId, BigDecimal availableBalance, BigDecimal ledgerBalance,
                   BigDecimal heldBalance, AccountStatus status, LocalDate openDate, LocalDate closeDate,
                   Integer branchId, UUID accountOfficerId, boolean overdraftAllowed,
                   BigDecimal overdraftLimit, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    // SETTERS
    public void setAccountId(UUID accountId) { this.accountId = accountId; }
    public void setAvailableBalance(BigDecimal availableBalance) { this.availableBalance = availableBalance; }
    public void setLedgerBalance(BigDecimal ledgerBalance) { this.ledgerBalance = ledgerBalance; }
    public void setStatus(AccountStatus status) { this.status = status; }
    public void setCloseDate(LocalDate closeDate) { this.closeDate = closeDate; }
    public void setBranchId(Integer branchId) { this.branchId = branchId; }
    public void setAccountOfficerId(UUID accountOfficerId) { this.accountOfficerId = accountOfficerId; }
    public void setOverdraftAllowed(boolean overdraftAllowed) { this.overdraftAllowed = overdraftAllowed; }
    public void setOverdraftLimit(BigDecimal overdraftLimit) { this.overdraftLimit = overdraftLimit; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
