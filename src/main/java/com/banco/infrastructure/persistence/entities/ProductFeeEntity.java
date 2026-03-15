package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.CalculationMode;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_fee", schema = "products")
public class ProductFeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fee_id")
    private Integer feeId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "fee_type", nullable = false, length = 60)
    private String feeType;

    @Enumerated(EnumType.STRING)
    @Column(name = "calculation_mode", nullable = false, length = 20)
    private CalculationMode calculationMode;

    @Column(name = "value", nullable = false, precision = 18, scale = 6)
    private BigDecimal value;

    @Column(name = "currency_id", length = 3)
    private String currencyId;

    @Column(name = "frequency", length = 20)
    private String frequency;

    @Column(name = "vat_applicable", nullable = false)
    private boolean vatApplicable = false;

    @Column(name = "active", nullable = false)
    private boolean active = true;


    // CONSTRUCTOR VACIO requerido por JPA
    public ProductFeeEntity() {}


    // GETTERS & SETTERS
    public Integer getFeeId() { return feeId; }
    public void setFeeId(Integer feeId) { this.feeId = feeId; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getFeeType() { return feeType; }
    public void setFeeType(String feeType) { this.feeType = feeType; }

    public CalculationMode getCalculationMode() { return calculationMode; }
    public void setCalculationMode(CalculationMode calculationMode) { this.calculationMode = calculationMode; }

    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }

    public String getCurrencyId() { return currencyId; }
    public void setCurrencyId(String currencyId) { this.currencyId = currencyId; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public boolean isVatApplicable() { return vatApplicable; }
    public void setVatApplicable(boolean vatApplicable) { this.vatApplicable = vatApplicable; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
