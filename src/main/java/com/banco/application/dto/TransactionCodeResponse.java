package com.banco.application.dto;

import com.banco.domain.model.valueobjects.TransactionCategory;

import java.time.LocalDate;

public class TransactionCodeResponse {

    private Short transactionCodeId;
    private String code;
    private String name;
    private String description;
    private TransactionCategory category;
    private String defaultEntryType;
    private String glDebitAccountCode;
    private String glCreditAccountCode;
    private String allowedChannels;
    private boolean requiresAuthorization;
    private boolean generatesTax;
    private boolean generatesGlEntry;
    private boolean reversible;
    private boolean active;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;


    // CONSTRUCTOR
    public TransactionCodeResponse(Short transactionCodeId, String code, String name, String description,
                                   TransactionCategory category, String defaultEntryType,
                                   String glDebitAccountCode, String glCreditAccountCode,
                                   String allowedChannels, boolean requiresAuthorization,
                                   boolean generatesTax, boolean generatesGlEntry, boolean reversible,
                                   boolean active, LocalDate effectiveDate, LocalDate expiryDate) {
        this.transactionCodeId = transactionCodeId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.defaultEntryType = defaultEntryType;
        this.glDebitAccountCode = glDebitAccountCode;
        this.glCreditAccountCode = glCreditAccountCode;
        this.allowedChannels = allowedChannels;
        this.requiresAuthorization = requiresAuthorization;
        this.generatesTax = generatesTax;
        this.generatesGlEntry = generatesGlEntry;
        this.reversible = reversible;
        this.active = active;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
    }


    // GETTERS
    public Short getTransactionCodeId() { return transactionCodeId; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public TransactionCategory getCategory() { return category; }
    public String getDefaultEntryType() { return defaultEntryType; }
    public String getGlDebitAccountCode() { return glDebitAccountCode; }
    public String getGlCreditAccountCode() { return glCreditAccountCode; }
    public String getAllowedChannels() { return allowedChannels; }
    public boolean isRequiresAuthorization() { return requiresAuthorization; }
    public boolean isGeneratesTax() { return generatesTax; }
    public boolean isGeneratesGlEntry() { return generatesGlEntry; }
    public boolean isReversible() { return reversible; }
    public boolean isActive() { return active; }
    public LocalDate getEffectiveDate() { return effectiveDate; }
    public LocalDate getExpiryDate() { return expiryDate; }
}
