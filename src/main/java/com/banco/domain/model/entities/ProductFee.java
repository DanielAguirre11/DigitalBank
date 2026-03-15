package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.CalculationMode;

import java.math.BigDecimal;

public class ProductFee {

    private Integer feeId;
    private final Integer productId;
    private String feeType;
    private CalculationMode calculationMode;
    private BigDecimal value;
    private String currencyId;
    private String frequency;
    private boolean vatApplicable;
    private boolean active;

    // Constructor for create (no ID yet)
    public ProductFee(Integer productId, String feeType, CalculationMode calculationMode,
                      BigDecimal value, String currencyId, String frequency,
                      boolean vatApplicable, boolean active) {
        this.productId = productId;
        this.feeType = feeType;
        this.calculationMode = calculationMode;
        this.value = value;
        this.currencyId = currencyId;
        this.frequency = frequency;
        this.vatApplicable = vatApplicable;
        this.active = active;
    }

    // Constructor for reconstruct from DB (all fields)
    public ProductFee(Integer feeId, Integer productId, String feeType,
                      CalculationMode calculationMode, BigDecimal value,
                      String currencyId, String frequency,
                      boolean vatApplicable, boolean active) {
        this.feeId = feeId;
        this.productId = productId;
        this.feeType = feeType;
        this.calculationMode = calculationMode;
        this.value = value;
        this.currencyId = currencyId;
        this.frequency = frequency;
        this.vatApplicable = vatApplicable;
        this.active = active;
    }

    // GETTERS
    public Integer getFeeId() { return feeId; }
    public Integer getProductId() { return productId; }
    public String getFeeType() { return feeType; }
    public CalculationMode getCalculationMode() { return calculationMode; }
    public BigDecimal getValue() { return value; }
    public String getCurrencyId() { return currencyId; }
    public String getFrequency() { return frequency; }
    public boolean isVatApplicable() { return vatApplicable; }
    public boolean isActive() { return active; }

    // SETTERS
    public void setFeeId(Integer feeId) { this.feeId = feeId; }
    public void setFeeType(String feeType) { this.feeType = feeType; }
    public void setCalculationMode(CalculationMode calculationMode) { this.calculationMode = calculationMode; }
    public void setValue(BigDecimal value) { this.value = value; }
    public void setCurrencyId(String currencyId) { this.currencyId = currencyId; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public void setVatApplicable(boolean vatApplicable) { this.vatApplicable = vatApplicable; }
    public void setActive(boolean active) { this.active = active; }
}
