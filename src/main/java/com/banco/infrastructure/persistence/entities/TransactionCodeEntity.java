package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.TransactionCategory;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transaction_code", schema = "catalog")
public class TransactionCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_code_id")
    private Short transactionCodeId;

    @Column(name = "code", nullable = false, length = 20, unique = true)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 300)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 40)
    private TransactionCategory category;

    @Column(name = "default_entry_type", nullable = false, length = 1)
    private String defaultEntryType;

    @Column(name = "gl_debit_account_code", length = 20)
    private String glDebitAccountCode;

    @Column(name = "gl_credit_account_code", length = 20)
    private String glCreditAccountCode;

    @Column(name = "allowed_channels", length = 200)
    private String allowedChannels;

    @Column(name = "requires_authorization", nullable = false)
    private boolean requiresAuthorization = false;

    @Column(name = "generates_tax", nullable = false)
    private boolean generatesTax = false;

    @Column(name = "generates_gl_entry", nullable = false)
    private boolean generatesGlEntry = true;

    @Column(name = "reversible", nullable = false)
    private boolean reversible = true;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;


    // CONSTRUCTOR VACIO requerido por JPA
    public TransactionCodeEntity() {}


    // GETTERS & SETTERS
    public Short getTransactionCodeId() { return transactionCodeId; }
    public void setTransactionCodeId(Short transactionCodeId) { this.transactionCodeId = transactionCodeId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TransactionCategory getCategory() { return category; }
    public void setCategory(TransactionCategory category) { this.category = category; }

    public String getDefaultEntryType() { return defaultEntryType; }
    public void setDefaultEntryType(String defaultEntryType) { this.defaultEntryType = defaultEntryType; }

    public String getGlDebitAccountCode() { return glDebitAccountCode; }
    public void setGlDebitAccountCode(String glDebitAccountCode) { this.glDebitAccountCode = glDebitAccountCode; }

    public String getGlCreditAccountCode() { return glCreditAccountCode; }
    public void setGlCreditAccountCode(String glCreditAccountCode) { this.glCreditAccountCode = glCreditAccountCode; }

    public String getAllowedChannels() { return allowedChannels; }
    public void setAllowedChannels(String allowedChannels) { this.allowedChannels = allowedChannels; }

    public boolean isRequiresAuthorization() { return requiresAuthorization; }
    public void setRequiresAuthorization(boolean requiresAuthorization) { this.requiresAuthorization = requiresAuthorization; }

    public boolean isGeneratesTax() { return generatesTax; }
    public void setGeneratesTax(boolean generatesTax) { this.generatesTax = generatesTax; }

    public boolean isGeneratesGlEntry() { return generatesGlEntry; }
    public void setGeneratesGlEntry(boolean generatesGlEntry) { this.generatesGlEntry = generatesGlEntry; }

    public boolean isReversible() { return reversible; }
    public void setReversible(boolean reversible) { this.reversible = reversible; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDate getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
