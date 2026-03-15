package com.banco.application.dto;

import com.banco.domain.model.valueobjects.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponse {

    private UUID transactionId;
    private UUID accountId;
    private LocalDateTime transactionDate;
    private LocalDate valueDate;
    private TransactionType transactionType;
    private Short transactionCodeId;
    private BigDecimal amount;
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    private String externalReference;
    private String channel;
    private String userId;
    private boolean reversed;
    private UUID originalTxnId;


    // CONSTRUCTOR
    public TransactionResponse(UUID transactionId, UUID accountId, LocalDateTime transactionDate,
                               LocalDate valueDate, TransactionType transactionType,
                               Short transactionCodeId, BigDecimal amount, BigDecimal balanceBefore,
                               BigDecimal balanceAfter, String externalReference, String channel,
                               String userId, boolean reversed, UUID originalTxnId) {
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
}
