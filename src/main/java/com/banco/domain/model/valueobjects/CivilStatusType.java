package com.banco.domain.model.valueobjects;

public enum CivilStatusType {

    Soltero("Soltero"),
    Casado("Casado"),
    Divorciado("Divorciado"),
    Viudo("Viudo"),
    Separado("Separado"),
    UnionDeHecho("Union de hecho");

    private final String valor;

    CivilStatusType(String valor) { this.valor = valor; }

    public String getValor() { return valor; }

    public static CivilStatusType fromValor(String valor) {
        for (CivilStatusType t : values()) {
            if (t.valor.equals(valor)) return t;
        }
        throw new IllegalArgumentException("Estado civil desconocido: " + valor);
    }
}
