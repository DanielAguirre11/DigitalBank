package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {

    private Integer productId;
    private final Short familyId;
    private final String code;
    private String name;
    private String description;
    private final String productType;
    private final String currencyId;
    private BigDecimal baseInterestRate;
    private BigDecimal maxInterestRate;
    private BigDecimal minInterestRate;
    private Integer minTermDays;
    private Integer maxTermDays;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private boolean requiresCollateral;
    private boolean taxApplicable;
    private ProductStatus status;
    private final LocalDate effectiveDate;
    private LocalDate expiryDate;
    private final LocalDateTime createdAt;

    // Constructor for create (sets createdAt = now)
    public Product(Short familyId, String code, String name, String description,
                   String productType, String currencyId,
                   BigDecimal baseInterestRate, BigDecimal maxInterestRate, BigDecimal minInterestRate,
                   Integer minTermDays, Integer maxTermDays,
                   BigDecimal minAmount, BigDecimal maxAmount,
                   boolean requiresCollateral, boolean taxApplicable,
                   ProductStatus status, LocalDate effectiveDate, LocalDate expiryDate) {
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
        this.createdAt = LocalDateTime.now();
    }

    // Constructor for reconstruct from DB (all fields including productId and createdAt)
    public Product(Integer productId, Short familyId, String code, String name, String description,
                   String productType, String currencyId,
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

    // SETTERS (only for mutable fields)
    public void setProductId(Integer productId) { this.productId = productId; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setBaseInterestRate(BigDecimal baseInterestRate) { this.baseInterestRate = baseInterestRate; }
    public void setMaxInterestRate(BigDecimal maxInterestRate) { this.maxInterestRate = maxInterestRate; }
    public void setMinInterestRate(BigDecimal minInterestRate) { this.minInterestRate = minInterestRate; }
    public void setMinTermDays(Integer minTermDays) { this.minTermDays = minTermDays; }
    public void setMaxTermDays(Integer maxTermDays) { this.maxTermDays = maxTermDays; }
    public void setMinAmount(BigDecimal minAmount) { this.minAmount = minAmount; }
    public void setMaxAmount(BigDecimal maxAmount) { this.maxAmount = maxAmount; }
    public void setRequiresCollateral(boolean requiresCollateral) { this.requiresCollateral = requiresCollateral; }
    public void setTaxApplicable(boolean taxApplicable) { this.taxApplicable = taxApplicable; }
    public void setStatus(ProductStatus status) { this.status = status; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
