package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.ProductStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "product", schema = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "family_id", nullable = false)
    private Short familyId;

    @Column(name = "code", nullable = false, length = 30, unique = true)
    private String code;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "product_type", nullable = false, length = 50)
    private String productType;

    @Column(name = "currency_id", nullable = false, length = 3)
    private String currencyId;

    @Column(name = "base_interest_rate", precision = 8, scale = 6)
    private BigDecimal baseInterestRate;

    @Column(name = "max_interest_rate", precision = 8, scale = 6)
    private BigDecimal maxInterestRate;

    @Column(name = "min_interest_rate", precision = 8, scale = 6)
    private BigDecimal minInterestRate;

    @Column(name = "min_term_days")
    private Integer minTermDays;

    @Column(name = "max_term_days")
    private Integer maxTermDays;

    @Column(name = "min_amount", precision = 18, scale = 2)
    private BigDecimal minAmount;

    @Column(name = "max_amount", precision = 18, scale = 2)
    private BigDecimal maxAmount;

    @Column(name = "requires_collateral", nullable = false)
    private boolean requiresCollateral = false;

    @Column(name = "tax_applicable", nullable = false)
    private boolean taxApplicable = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ProductStatus status = ProductStatus.ACTIVE;

    @Column(name = "effective_date", nullable = false)
    private LocalDate effectiveDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    // CONSTRUCTOR VACIO requerido por JPA
    public ProductEntity() {}


    // GETTERS & SETTERS
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

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

    public LocalDateTime getCreatedAt() { return createdAt; }
}
