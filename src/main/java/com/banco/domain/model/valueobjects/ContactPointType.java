package com.banco.domain.model.valueobjects;

public enum ContactPointType {

    DireccionElectronica("Dirección Electrónica"),
    DireccionPostal("Dirección Postal"),
    NumeroDeTelefono("Número de Teléfono"),
    DireccionDeRedSocial("Dirección de Red Social");

    private final String valor;

    ContactPointType(String valor) { this.valor = valor; }

    public String getValor() { return valor; }

    public static ContactPointType fromValor(String valor) {
        for (ContactPointType t : values()) {
            if (t.valor.equals(valor)) return t;
        }
        throw new IllegalArgumentException("Tipo de punto de contacto desconocido: " + valor);
    }
}
