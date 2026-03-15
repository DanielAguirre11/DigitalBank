package com.banco.application.dto;

import com.banco.domain.model.valueobjects.AccountStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class ActualizarAccountRequest {

    private AccountStatus status;
    private LocalDate closeDate;
    private Integer branchId;
    private UUID accountOfficerId;
    private Boolean overdraftAllowed;
    private BigDecimal overdraftLimit;


    // CONSTRUCTORS
    public ActualizarAccountRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<AccountStatus> getStatus() { return Optional.ofNullable(status); }
    public void setStatus(AccountStatus status) { this.status = status; }

    public Optional<LocalDate> getCloseDate() { return Optional.ofNullable(closeDate); }
    public void setCloseDate(LocalDate closeDate) { this.closeDate = closeDate; }

    public Optional<Integer> getBranchId() { return Optional.ofNullable(branchId); }
    public void setBranchId(Integer branchId) { this.branchId = branchId; }

    public Optional<UUID> getAccountOfficerId() { return Optional.ofNullable(accountOfficerId); }
    public void setAccountOfficerId(UUID accountOfficerId) { this.accountOfficerId = accountOfficerId; }

    public Optional<Boolean> getOverdraftAllowed() { return Optional.ofNullable(overdraftAllowed); }
    public void setOverdraftAllowed(Boolean overdraftAllowed) { this.overdraftAllowed = overdraftAllowed; }

    public Optional<BigDecimal> getOverdraftLimit() { return Optional.ofNullable(overdraftLimit); }
    public void setOverdraftLimit(BigDecimal overdraftLimit) { this.overdraftLimit = overdraftLimit; }
}
