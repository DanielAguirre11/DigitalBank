package com.banco.application.dto;

import com.banco.domain.model.valueobjects.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class ActualizarProductRequest {

    private String name;
    private String description;
    private BigDecimal baseInterestRate;
    private BigDecimal maxInterestRate;
    private BigDecimal minInterestRate;
    private Integer minTermDays;
    private Integer maxTermDays;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Boolean requiresCollateral;
    private Boolean taxApplicable;
    private ProductStatus status;
    private LocalDate expiryDate;


    // CONSTRUCTORS
    public ActualizarProductRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<String> getName() { return Optional.ofNullable(name); }
    public void setName(String name) { this.name = name; }

    public Optional<String> getDescription() { return Optional.ofNullable(description); }
    public void setDescription(String description) { this.description = description; }

    public Optional<BigDecimal> getBaseInterestRate() { return Optional.ofNullable(baseInterestRate); }
    public void setBaseInterestRate(BigDecimal baseInterestRate) { this.baseInterestRate = baseInterestRate; }

    public Optional<BigDecimal> getMaxInterestRate() { return Optional.ofNullable(maxInterestRate); }
    public void setMaxInterestRate(BigDecimal maxInterestRate) { this.maxInterestRate = maxInterestRate; }

    public Optional<BigDecimal> getMinInterestRate() { return Optional.ofNullable(minInterestRate); }
    public void setMinInterestRate(BigDecimal minInterestRate) { this.minInterestRate = minInterestRate; }

    public Optional<Integer> getMinTermDays() { return Optional.ofNullable(minTermDays); }
    public void setMinTermDays(Integer minTermDays) { this.minTermDays = minTermDays; }

    public Optional<Integer> getMaxTermDays() { return Optional.ofNullable(maxTermDays); }
    public void setMaxTermDays(Integer maxTermDays) { this.maxTermDays = maxTermDays; }

    public Optional<BigDecimal> getMinAmount() { return Optional.ofNullable(minAmount); }
    public void setMinAmount(BigDecimal minAmount) { this.minAmount = minAmount; }

    public Optional<BigDecimal> getMaxAmount() { return Optional.ofNullable(maxAmount); }
    public void setMaxAmount(BigDecimal maxAmount) { this.maxAmount = maxAmount; }

    public Optional<Boolean> getRequiresCollateral() { return Optional.ofNullable(requiresCollateral); }
    public void setRequiresCollateral(Boolean requiresCollateral) { this.requiresCollateral = requiresCollateral; }

    public Optional<Boolean> getTaxApplicable() { return Optional.ofNullable(taxApplicable); }
    public void setTaxApplicable(Boolean taxApplicable) { this.taxApplicable = taxApplicable; }

    public Optional<ProductStatus> getStatus() { return Optional.ofNullable(status); }
    public void setStatus(ProductStatus status) { this.status = status; }

    public Optional<LocalDate> getExpiryDate() { return Optional.ofNullable(expiryDate); }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
