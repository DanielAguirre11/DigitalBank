package com.banco.application.dto;

import com.banco.domain.model.valueobjects.RenewalMode;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TimeDepositRequest {

    @NotNull
    private UUID accountId;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal originalAmount;

    @NotNull
    @DecimalMin("0.000001")
    private BigDecimal agreedRate;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate maturityDate;

    @NotNull
    @Min(1)
    private int termDays;

    @NotNull
    private RenewalMode renewalMode;

    private boolean capitalizeInterest = true;

    // Default constructor
    public TimeDepositRequest() {}

    // Getters
    public UUID getAccountId() { return accountId; }
    public BigDecimal getOriginalAmount() { return originalAmount; }
    public BigDecimal getAgreedRate() { return agreedRate; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getMaturityDate() { return maturityDate; }
    public int getTermDays() { return termDays; }
    public RenewalMode getRenewalMode() { return renewalMode; }
    public boolean isCapitalizeInterest() { return capitalizeInterest; }

    // Setters
    public void setAccountId(UUID accountId) { this.accountId = accountId; }
    public void setOriginalAmount(BigDecimal originalAmount) { this.originalAmount = originalAmount; }
    public void setAgreedRate(BigDecimal agreedRate) { this.agreedRate = agreedRate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setMaturityDate(LocalDate maturityDate) { this.maturityDate = maturityDate; }
    public void setTermDays(int termDays) { this.termDays = termDays; }
    public void setRenewalMode(RenewalMode renewalMode) { this.renewalMode = renewalMode; }
    public void setCapitalizeInterest(boolean capitalizeInterest) { this.capitalizeInterest = capitalizeInterest; }
}
