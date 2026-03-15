package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.DepositStatus;
import com.banco.domain.model.valueobjects.RenewalMode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TimeDeposit {

    private UUID depositId;
    private final UUID accountId;
    private final BigDecimal originalAmount;
    private final BigDecimal agreedRate;
    private final LocalDate startDate;
    private final LocalDate maturityDate;
    private final int termDays;
    private final RenewalMode renewalMode;
    private final boolean capitalizeInterest;
    private DepositStatus status;
    private BigDecimal accruedInterest;

    // Constructor for create (no depositId — assigned after save)
    public TimeDeposit(UUID accountId, BigDecimal originalAmount, BigDecimal agreedRate,
                       LocalDate startDate, LocalDate maturityDate, int termDays,
                       RenewalMode renewalMode, boolean capitalizeInterest) {
        this.accountId = accountId;
        this.originalAmount = originalAmount;
        this.agreedRate = agreedRate;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.termDays = termDays;
        this.renewalMode = renewalMode;
        this.capitalizeInterest = capitalizeInterest;
        this.status = DepositStatus.ACTIVE;
        this.accruedInterest = BigDecimal.ZERO;
    }

    // Constructor for reconstruct from DB (all fields)
    public TimeDeposit(UUID depositId, UUID accountId, BigDecimal originalAmount, BigDecimal agreedRate,
                       LocalDate startDate, LocalDate maturityDate, int termDays,
                       RenewalMode renewalMode, boolean capitalizeInterest,
                       DepositStatus status, BigDecimal accruedInterest) {
        this.depositId = depositId;
        this.accountId = accountId;
        this.originalAmount = originalAmount;
        this.agreedRate = agreedRate;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.termDays = termDays;
        this.renewalMode = renewalMode;
        this.capitalizeInterest = capitalizeInterest;
        this.status = status;
        this.accruedInterest = accruedInterest;
    }

    // Getters
    public UUID getDepositId() { return depositId; }
    public UUID getAccountId() { return accountId; }
    public BigDecimal getOriginalAmount() { return originalAmount; }
    public BigDecimal getAgreedRate() { return agreedRate; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getMaturityDate() { return maturityDate; }
    public int getTermDays() { return termDays; }
    public RenewalMode getRenewalMode() { return renewalMode; }
    public boolean isCapitalizeInterest() { return capitalizeInterest; }
    public DepositStatus getStatus() { return status; }
    public BigDecimal getAccruedInterest() { return accruedInterest; }

    // Setters (mutable fields)
    public void setDepositId(UUID depositId) { this.depositId = depositId; }
    public void setStatus(DepositStatus status) { this.status = status; }
    public void setAccruedInterest(BigDecimal accruedInterest) { this.accruedInterest = accruedInterest; }
}
