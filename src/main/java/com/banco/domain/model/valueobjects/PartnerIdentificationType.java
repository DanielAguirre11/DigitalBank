package com.banco.domain.model.valueobjects;

public enum PartnerIdentificationType {

    Cedula("Cédula"),
    RUCS("RUCS"),
    Pasaporte("Pasaporte");

    private final String valor;

    PartnerIdentificationType(String valor) { this.valor = valor; }

    public String getValor() { return valor; }

    public static PartnerIdentificationType fromValor(String valor) {
        for (PartnerIdentificationType t : values()) {
            if (t.valor.equals(valor)) return t;
        }
        throw new IllegalArgumentException("Tipo de identificacion desconocido: " + valor);
    }
}
