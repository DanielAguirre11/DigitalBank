package com.banco.application.dto;

import com.banco.domain.model.valueobjects.CalculationMode;

import java.math.BigDecimal;
import java.util.Optional;

public class ActualizarProductFeeRequest {

    private String feeType;
    private CalculationMode calculationMode;
    private BigDecimal value;
    private String currencyId;
    private String frequency;
    private Boolean vatApplicable;
    private Boolean active;


    // CONSTRUCTORS
    public ActualizarProductFeeRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<String> getFeeType() { return Optional.ofNullable(feeType); }
    public void setFeeType(String feeType) { this.feeType = feeType; }

    public Optional<CalculationMode> getCalculationMode() { return Optional.ofNullable(calculationMode); }
    public void setCalculationMode(CalculationMode calculationMode) { this.calculationMode = calculationMode; }

    public Optional<BigDecimal> getValue() { return Optional.ofNullable(value); }
    public void setValue(BigDecimal value) { this.value = value; }

    public Optional<String> getCurrencyId() { return Optional.ofNullable(currencyId); }
    public void setCurrencyId(String currencyId) { this.currencyId = currencyId; }

    public Optional<String> getFrequency() { return Optional.ofNullable(frequency); }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public Optional<Boolean> getVatApplicable() { return Optional.ofNullable(vatApplicable); }
    public void setVatApplicable(Boolean vatApplicable) { this.vatApplicable = vatApplicable; }

    public Optional<Boolean> getActive() { return Optional.ofNullable(active); }
    public void setActive(Boolean active) { this.active = active; }
}
