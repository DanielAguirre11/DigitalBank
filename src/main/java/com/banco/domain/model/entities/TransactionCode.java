package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.TransactionCategory;

import java.time.LocalDate;
import java.util.Objects;

public class TransactionCode {

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


    // CONSTRUCTOR PARA CREAR
    public TransactionCode(String code, String name, String description, TransactionCategory category,
                           String defaultEntryType, String glDebitAccountCode, String glCreditAccountCode,
                           String allowedChannels, boolean requiresAuthorization, boolean generatesTax,
                           boolean generatesGlEntry, boolean reversible, boolean active,
                           LocalDate effectiveDate, LocalDate expiryDate) {
        this.code = Objects.requireNonNull(code, "El codigo de transaccion es obligatorio");
        this.name = Objects.requireNonNull(name, "El nombre de transaccion es obligatorio");
        this.description = description;
        this.category = Objects.requireNonNull(category, "La categoria es obligatoria");
        this.defaultEntryType = Objects.requireNonNull(defaultEntryType, "El tipo de asiento es obligatorio");
        this.glDebitAccountCode = glDebitAccountCode;
        this.glCreditAccountCode = glCreditAccountCode;
        this.allowedChannels = allowedChannels;
        this.requiresAuthorization = requiresAuthorization;
        this.generatesTax = generatesTax;
        this.generatesGlEntry = generatesGlEntry;
        this.reversible = reversible;
        this.active = active;
        this.effectiveDate = effectiveDate != null ? effectiveDate : LocalDate.now();
        this.expiryDate = expiryDate;
    }

    // CONSTRUCTOR PARA RECONSTRUIR DESDE BD
    public TransactionCode(Short transactionCodeId, String code, String name, String description,
                           TransactionCategory category, String defaultEntryType,
                           String glDebitAccountCode, String glCreditAccountCode, String allowedChannels,
                           boolean requiresAuthorization, boolean generatesTax, boolean generatesGlEntry,
                           boolean reversible, boolean active, LocalDate effectiveDate, LocalDate expiryDate) {
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

    // SETTERS
    public void setTransactionCodeId(Short transactionCodeId) { this.transactionCodeId = transactionCodeId; }
    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(TransactionCategory category) { this.category = category; }
    public void setDefaultEntryType(String defaultEntryType) { this.defaultEntryType = defaultEntryType; }
    public void setGlDebitAccountCode(String glDebitAccountCode) { this.glDebitAccountCode = glDebitAccountCode; }
    public void setGlCreditAccountCode(String glCreditAccountCode) { this.glCreditAccountCode = glCreditAccountCode; }
    public void setAllowedChannels(String allowedChannels) { this.allowedChannels = allowedChannels; }
    public void setRequiresAuthorization(boolean requiresAuthorization) { this.requiresAuthorization = requiresAuthorization; }
    public void setGeneratesTax(boolean generatesTax) { this.generatesTax = generatesTax; }
    public void setGeneratesGlEntry(boolean generatesGlEntry) { this.generatesGlEntry = generatesGlEntry; }
    public void setReversible(boolean reversible) { this.reversible = reversible; }
    public void setActive(boolean active) { this.active = active; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
