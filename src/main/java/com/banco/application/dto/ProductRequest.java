package com.banco.application.dto;

import com.banco.domain.model.valueobjects.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductRequest {

    @NotNull
    private Short familyId;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String productType;

    @NotBlank
    private String currencyId;

    private BigDecimal baseInterestRate;
    private BigDecimal maxInterestRate;
    private BigDecimal minInterestRate;
    private Integer minTermDays;
    private Integer maxTermDays;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private boolean requiresCollateral = false;
    private boolean taxApplicable = true;

    @NotNull
    private ProductStatus status;

    @NotNull
    private LocalDate effectiveDate;

    private LocalDate expiryDate;


    // CONSTRUCTORS
    public ProductRequest() {}


    // GETTERS & SETTERS
    public Short getFamilyId() { return familyId; }
    public void setFamilyId(Short familyId) { this.familyId = familyId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public String getCurrencyId() { return currencyId; }
    public void setCurrencyId(String currencyId) { this.currencyId = currencyId; }

    public BigDecimal getBaseInterestRate() { return baseInterestRate; }
    public void setBaseInterestRate(BigDecimal baseInterestRate) { this.baseInterestRate = baseInterestRate; }

    public BigDecimal getMaxInterestRate() { return maxInterestRate; }
    public void setMaxInterestRate(BigDecimal maxInterestRate) { this.maxInterestRate = maxInterestRate; }

    public BigDecimal getMinInterestRate() { return minInterestRate; }
    public void setMinInterestRate(BigDecimal minInterestRate) { this.minInterestRate = minInterestRate; }

    public Integer getMinTermDays() { return minTermDays; }
    public void setMinTermDays(Integer minTermDays) { this.minTermDays = minTermDays; }

    public Integer getMaxTermDays() { return maxTermDays; }
    public void setMaxTermDays(Integer maxTermDays) { this.maxTermDays = maxTermDays; }

    public BigDecimal getMinAmount() { return minAmount; }
    public void setMinAmount(BigDecimal minAmount) { this.minAmount = minAmount; }

    public BigDecimal getMaxAmount() { return maxAmount; }
    public void setMaxAmount(BigDecimal maxAmount) { this.maxAmount = maxAmount; }

    public boolean isRequiresCollateral() { return requiresCollateral; }
    public void setRequiresCollateral(boolean requiresCollateral) { this.requiresCollateral = requiresCollateral; }

    public boolean isTaxApplicable() { return taxApplicable; }
    public void setTaxApplicable(boolean taxApplicable) { this.taxApplicable = taxApplicable; }

    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }

    public LocalDate getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
