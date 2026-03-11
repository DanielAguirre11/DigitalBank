package com.banco.domain.model.valueobjects;

public enum PartnerLocationType {

    LugarDeNacimiento("Lugar de Nacimiento"),
    DireccionResidencial("Dirección Residencial"),
    DireccionDeDomicilio("Dirección de Domicilio"),
    DireccionDeTrabajo("Dirección de Trabajo");

    private final String valor;

    PartnerLocationType(String valor) { this.valor = valor; }

    public String getValor() { return valor; }

    public static PartnerLocationType fromValor(String valor) {
        for (PartnerLocationType t : values()) {
            if (t.valor.equals(valor)) return t;
        }
        throw new IllegalArgumentException("Tipo de localizacion desconocido: " + valor);
    }
}
