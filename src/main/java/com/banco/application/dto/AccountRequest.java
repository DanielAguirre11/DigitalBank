package com.banco.application.dto;

import com.banco.domain.model.valueobjects.AccountStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class AccountRequest {

    @NotBlank(message = "El numero de cuenta es obligatorio")
    @Size(max = 30)
    private String accountNumber;

    @NotNull(message = "El producto es obligatorio")
    private Integer productId;

    @NotNull(message = "El cliente es obligatorio")
    private UUID customerId;

    @NotBlank(message = "La moneda es obligatoria")
    @Size(min = 3, max = 3, message = "La moneda debe ser un codigo de 3 caracteres")
    private String currencyId;

    private AccountStatus status;

    private LocalDate openDate;

    private Integer branchId;

    private UUID accountOfficerId;

    private boolean overdraftAllowed = false;

    private BigDecimal overdraftLimit;


    // CONSTRUCTORS
    public AccountRequest() {}


    // GETTERS & SETTERS
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public UUID getCustomerId() { return customerId; }
    public void setCustomerId(UUID customerId) { this.customerId = customerId; }

    public String getCurrencyId() { return currencyId; }
    public void setCurrencyId(String currencyId) { this.currencyId = currencyId; }

    public AccountStatus getStatus() { return status; }
    public void setStatus(AccountStatus status) { this.status = status; }

    public LocalDate getOpenDate() { return openDate; }
    public void setOpenDate(LocalDate openDate) { this.openDate = openDate; }

    public Integer getBranchId() { return branchId; }
    public void setBranchId(Integer branchId) { this.branchId = branchId; }

    public UUID getAccountOfficerId() { return accountOfficerId; }
    public void setAccountOfficerId(UUID accountOfficerId) { this.accountOfficerId = accountOfficerId; }

    public boolean isOverdraftAllowed() { return overdraftAllowed; }
    public void setOverdraftAllowed(boolean overdraftAllowed) { this.overdraftAllowed = overdraftAllowed; }

    public BigDecimal getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(BigDecimal overdraftLimit) { this.overdraftLimit = overdraftLimit; }
}
