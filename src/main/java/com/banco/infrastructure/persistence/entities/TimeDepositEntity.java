package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.DepositStatus;
import com.banco.domain.model.valueobjects.RenewalMode;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "time_deposit", schema = "accounts")
public class TimeDepositEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "deposit_id")
    private UUID depositId;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(name = "original_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal originalAmount;

    @Column(name = "agreed_rate", nullable = false, precision = 8, scale = 6)
    private BigDecimal agreedRate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "maturity_date", nullable = false)
    private LocalDate maturityDate;

    @Column(name = "term_days", nullable = false)
    private int termDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "renewal_mode", nullable = false, length = 30)
    private RenewalMode renewalMode;

    @Column(name = "capitalize_interest", nullable = false)
    private boolean capitalizeInterest;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private DepositStatus status;

    @Column(name = "accrued_interest", nullable = false, precision = 18, scale = 2)
    private BigDecimal accruedInterest;


    // Default constructor required by JPA
    public TimeDepositEntity() {}

    // All-args constructor
    public TimeDepositEntity(UUID depositId, UUID accountId, BigDecimal originalAmount,
                              BigDecimal agreedRate, LocalDate startDate, LocalDate maturityDate,
                              int termDays, RenewalMode renewalMode, boolean capitalizeInterest,
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


    // Getters & Setters
    public UUID getDepositId() { return depositId; }
    public void setDepositId(UUID depositId) { this.depositId = depositId; }

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public BigDecimal getOriginalAmount() { return originalAmount; }
    public void setOriginalAmount(BigDecimal originalAmount) { this.originalAmount = originalAmount; }

    public BigDecimal getAgreedRate() { return agreedRate; }
    public void setAgreedRate(BigDecimal agreedRate) { this.agreedRate = agreedRate; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getMaturityDate() { return maturityDate; }
    public void setMaturityDate(LocalDate maturityDate) { this.maturityDate = maturityDate; }

    public int getTermDays() { return termDays; }
    public void setTermDays(int termDays) { this.termDays = termDays; }

    public RenewalMode getRenewalMode() { return renewalMode; }
    public void setRenewalMode(RenewalMode renewalMode) { this.renewalMode = renewalMode; }

    public boolean isCapitalizeInterest() { return capitalizeInterest; }
    public void setCapitalizeInterest(boolean capitalizeInterest) { this.capitalizeInterest = capitalizeInterest; }

    public DepositStatus getStatus() { return status; }
    public void setStatus(DepositStatus status) { this.status = status; }

    public BigDecimal getAccruedInterest() { return accruedInterest; }
    public void setAccruedInterest(BigDecimal accruedInterest) { this.accruedInterest = accruedInterest; }
}
