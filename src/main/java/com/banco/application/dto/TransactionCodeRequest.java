package com.banco.application.dto;

import com.banco.domain.model.valueobjects.TransactionCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TransactionCodeRequest {

    @NotBlank(message = "El codigo es obligatorio")
    @Size(max = 20)
    private String code;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String name;

    @Size(max = 300)
    private String description;

    @NotNull(message = "La categoria es obligatoria")
    private TransactionCategory category;

    @NotNull(message = "El tipo de asiento es obligatorio")
    @Pattern(regexp = "^[DC]$", message = "El tipo de asiento debe ser D o C")
    private String defaultEntryType;

    @Size(max = 20)
    private String glDebitAccountCode;

    @Size(max = 20)
    private String glCreditAccountCode;

    @Size(max = 200)
    private String allowedChannels;

    private boolean requiresAuthorization = false;
    private boolean generatesTax = false;
    private boolean generatesGlEntry = true;
    private boolean reversible = true;
    private boolean active = true;

    private LocalDate effectiveDate;
    private LocalDate expiryDate;


    // CONSTRUCTORS
    public TransactionCodeRequest() {}


    // GETTERS & SETTERS
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
