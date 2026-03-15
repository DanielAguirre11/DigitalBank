package com.banco.application.dto;

import com.banco.domain.model.valueobjects.TransactionCategory;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Optional;

public class ActualizarTransactionCodeRequest {

    @Size(max = 100)
    private String name;

    @Size(max = 300)
    private String description;

    private TransactionCategory category;

    @Pattern(regexp = "^[DC]$", message = "El tipo de asiento debe ser D o C")
    private String defaultEntryType;

    @Size(max = 20)
    private String glDebitAccountCode;

    @Size(max = 20)
    private String glCreditAccountCode;

    @Size(max = 200)
    private String allowedChannels;

    private Boolean requiresAuthorization;
    private Boolean generatesTax;
    private Boolean generatesGlEntry;
    private Boolean reversible;
    private Boolean active;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;


    // CONSTRUCTORS
    public ActualizarTransactionCodeRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<String> getName() { return Optional.ofNullable(name); }
    public void setName(String name) { this.name = name; }

    public Optional<String> getDescription() { return Optional.ofNullable(description); }
    public void setDescription(String description) { this.description = description; }

    public Optional<TransactionCategory> getCategory() { return Optional.ofNullable(category); }
    public void setCategory(TransactionCategory category) { this.category = category; }

    public Optional<String> getDefaultEntryType() { return Optional.ofNullable(defaultEntryType); }
    public void setDefaultEntryType(String defaultEntryType) { this.defaultEntryType = defaultEntryType; }

    public Optional<String> getGlDebitAccountCode() { return Optional.ofNullable(glDebitAccountCode); }
    public void setGlDebitAccountCode(String glDebitAccountCode) { this.glDebitAccountCode = glDebitAccountCode; }

    public Optional<String> getGlCreditAccountCode() { return Optional.ofNullable(glCreditAccountCode); }
    public void setGlCreditAccountCode(String glCreditAccountCode) { this.glCreditAccountCode = glCreditAccountCode; }

    public Optional<String> getAllowedChannels() { return Optional.ofNullable(allowedChannels); }
    public void setAllowedChannels(String allowedChannels) { this.allowedChannels = allowedChannels; }

    public Optional<Boolean> getRequiresAuthorization() { return Optional.ofNullable(requiresAuthorization); }
    public void setRequiresAuthorization(Boolean requiresAuthorization) { this.requiresAuthorization = requiresAuthorization; }

    public Optional<Boolean> getGeneratesTax() { return Optional.ofNullable(generatesTax); }
    public void setGeneratesTax(Boolean generatesTax) { this.generatesTax = generatesTax; }

    public Optional<Boolean> getGeneratesGlEntry() { return Optional.ofNullable(generatesGlEntry); }
    public void setGeneratesGlEntry(Boolean generatesGlEntry) { this.generatesGlEntry = generatesGlEntry; }

    public Optional<Boolean> getReversible() { return Optional.ofNullable(reversible); }
    public void setReversible(Boolean reversible) { this.reversible = reversible; }

    public Optional<Boolean> getActive() { return Optional.ofNullable(active); }
    public void setActive(Boolean active) { this.active = active; }

    public Optional<LocalDate> getEffectiveDate() { return Optional.ofNullable(effectiveDate); }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }

    public Optional<LocalDate> getExpiryDate() { return Optional.ofNullable(expiryDate); }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
