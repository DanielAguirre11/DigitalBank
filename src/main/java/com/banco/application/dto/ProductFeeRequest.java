package com.banco.application.dto;

import com.banco.domain.model.valueobjects.CalculationMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProductFeeRequest {

    @NotNull
    private Integer productId;

    @NotBlank
    private String feeType;

    @NotNull
    private CalculationMode calculationMode;

    @NotNull
    private BigDecimal value;

    private String currencyId;
    private String frequency;
    private boolean vatApplicable = false;
    private boolean active = true;


    // CONSTRUCTORS
    public ProductFeeRequest() {}


    // GETTERS & SETTERS
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
