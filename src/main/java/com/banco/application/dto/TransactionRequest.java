package com.banco.application.dto;

import com.banco.domain.model.valueobjects.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TransactionRequest {

    @NotNull(message = "El account id es obligatorio")
    private UUID accountId;

    @NotNull(message = "La fecha valor es obligatoria")
    private LocalDate valueDate;

    @NotNull(message = "El tipo de transaccion es obligatorio")
    private TransactionType transactionType;

    @NotNull(message = "El codigo de transaccion es obligatorio")
    private Short transactionCodeId;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a cero")
    private BigDecimal amount;

    @Size(max = 100)
    private String externalReference;

    @Size(max = 30)
    private String channel;

    @Size(max = 50)
    private String userId;


    // CONSTRUCTORS
    public TransactionRequest() {}


    // GETTERS & SETTERS
    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public LocalDate getValueDate() { return valueDate; }
    public void setValueDate(LocalDate valueDate) { this.valueDate = valueDate; }

    public TransactionType getTransactionType() { return transactionType; }
    public void setTransactionType(TransactionType transactionType) { this.transactionType = transactionType; }

    public Short getTransactionCodeId() { return transactionCodeId; }
    public void setTransactionCodeId(Short transactionCodeId) { this.transactionCodeId = transactionCodeId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getExternalReference() { return externalReference; }
    public void setExternalReference(String externalReference) { this.externalReference = externalReference; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
