package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Transaction {

    private UUID transactionId;
    private final UUID accountId;
    private LocalDateTime transactionDate;
    private final LocalDate valueDate;
    private final TransactionType transactionType;
    private final Short transactionCodeId;
    private final BigDecimal amount;
    private final BigDecimal balanceBefore;
    private final BigDecimal balanceAfter;
    private String externalReference;
    private String channel;
    private String userId;
    private boolean reversed;
    private final UUID originalTxnId;


    // CONSTRUCTOR PARA CREAR
    public Transaction(UUID accountId, LocalDate valueDate, TransactionType transactionType,
                       Short transactionCodeId, BigDecimal amount, BigDecimal balanceBefore,
                       BigDecimal balanceAfter, String externalReference, String channel,
                       String userId, UUID originalTxnId) {
        this.accountId = Objects.requireNonNull(accountId, "El accountId es obligatorio");
        this.valueDate = Objects.requireNonNull(valueDate, "La fecha valor es obligatoria");
        this.transactionType = Objects.requireNonNull(transactionType, "El tipo de transaccion es obligatorio");
        this.transactionCodeId = Objects.requireNonNull(transactionCodeId, "El codigo de transaccion es obligatorio");
        this.amount = Objects.requireNonNull(amount, "El monto es obligatorio");
        this.balanceBefore = Objects.requireNonNull(balanceBefore, "El saldo anterior es obligatorio");
        this.balanceAfter = Objects.requireNonNull(balanceAfter, "El saldo posterior es obligatorio");
        this.externalReference = externalReference;
        this.channel = channel;
        this.userId = userId;
        this.reversed = false;
        this.originalTxnId = originalTxnId;
        this.transactionDate = LocalDateTime.now();
    }

    // CONSTRUCTOR PARA RECONSTRUIR DESDE BD
    public Transaction(UUID transactionId, UUID accountId, LocalDateTime transactionDate,
                       LocalDate valueDate, TransactionType transactionType, Short transactionCodeId,
                       BigDecimal amount, BigDecimal balanceBefore, BigDecimal balanceAfter,
                       String externalReference, String channel, String userId,
                       boolean reversed, UUID originalTxnId) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionDate = transactionDate;
        this.valueDate = valueDate;
        this.transactionType = transactionType;
        this.transactionCodeId = transactionCodeId;
        this.amount = amount;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.externalReference = externalReference;
        this.channel = channel;
        this.userId = userId;
        this.reversed = reversed;
        this.originalTxnId = originalTxnId;
    }

    // GETTERS
    public UUID getTransactionId() { return transactionId; }
    public UUID getAccountId() { return accountId; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public LocalDate getValueDate() { return valueDate; }
    public TransactionType getTransactionType() { return transactionType; }
    public Short getTransactionCodeId() { return transactionCodeId; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getBalanceBefore() { return balanceBefore; }
    public BigDecimal getBalanceAfter() { return balanceAfter; }
    public String getExternalReference() { return externalReference; }
    public String getChannel() { return channel; }
    public String getUserId() { return userId; }
    public boolean isReversed() { return reversed; }
    public UUID getOriginalTxnId() { return originalTxnId; }

    // SETTERS
    public void setTransactionId(UUID transactionId) { this.transactionId = transactionId; }
    public void setReversed(boolean reversed) { this.reversed = reversed; }
}
