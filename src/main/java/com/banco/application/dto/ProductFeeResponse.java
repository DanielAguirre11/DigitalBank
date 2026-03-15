package com.banco.application.dto;

import com.banco.domain.model.valueobjects.CalculationMode;

import java.math.BigDecimal;

public class ProductFeeResponse {

    private final Integer feeId;
    private final Integer productId;
    private final String feeType;
    private final CalculationMode calculationMode;
    private final BigDecimal value;
    private final String currencyId;
    private final String frequency;
    private final boolean vatApplicable;
    private final boolean active;


    // CONSTRUCTOR
    public ProductFeeResponse(Integer feeId, Integer productId, String feeType,
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
}
