package com.banco.application.dto;

import com.banco.domain.model.valueobjects.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductResponse {

    private final Integer productId;
    private final Short familyId;
    private final String code;
    private final String name;
    private final String description;
    private final String productType;
    private final String currencyId;
    private final BigDecimal baseInterestRate;
    private final BigDecimal maxInterestRate;
    private final BigDecimal minInterestRate;
    private final Integer minTermDays;
    private final Integer maxTermDays;
    private final BigDecimal minAmount;
    private final BigDecimal maxAmount;
    private final boolean requiresCollateral;
    private final boolean taxApplicable;
    private final ProductStatus status;
    private final LocalDate effectiveDate;
    private final LocalDate expiryDate;
    private final LocalDateTime createdAt;


    // CONSTRUCTOR
    public ProductResponse(Integer productId, Short familyId, String code, String name,
                           String description, String productType, String currencyId,
                           BigDecimal baseInterestRate, BigDecimal maxInterestRate, BigDecimal minInterestRate,
                           Integer minTermDays, Integer maxTermDays,
                           BigDecimal minAmount, BigDecimal maxAmount,
                           boolean requiresCollateral, boolean taxApplicable,
                           ProductStatus status, LocalDate effectiveDate, LocalDate expiryDate,
                           LocalDateTime createdAt) {
        this.productId = productId;
        this.familyId = familyId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.currencyId = currencyId;
        this.baseInterestRate = baseInterestRate;
        this.maxInterestRate = maxInterestRate;
        this.minInterestRate = minInterestRate;
        this.minTermDays = minTermDays;
        this.maxTermDays = maxTermDays;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.requiresCollateral = requiresCollateral;
        this.taxApplicable = taxApplicable;
        this.status = status;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
        this.createdAt = createdAt;
    }


    // GETTERS
    public Integer getProductId() { return productId; }
    public Short getFamilyId() { return familyId; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getProductType() { return productType; }
    public String getCurrencyId() { return currencyId; }
    public BigDecimal getBaseInterestRate() { return baseInterestRate; }
    public BigDecimal getMaxInterestRate() { return maxInterestRate; }
    public BigDecimal getMinInterestRate() { return minInterestRate; }
    public Integer getMinTermDays() { return minTermDays; }
    public Integer getMaxTermDays() { return maxTermDays; }
    public BigDecimal getMinAmount() { return minAmount; }
    public BigDecimal getMaxAmount() { return maxAmount; }
    public boolean isRequiresCollateral() { return requiresCollateral; }
    public boolean isTaxApplicable() { return taxApplicable; }
    public ProductStatus getStatus() { return status; }
    public LocalDate getEffectiveDate() { return effectiveDate; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
