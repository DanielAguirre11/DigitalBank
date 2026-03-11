package com.banco.domain.model.valueobjects;

public enum PoliticalExposureType {

    ExposicionPoliticaExtranjera("Exposición Política Extranjera"),
    ExposicionPoliticaNacional("Exposición Política Nacional"),
    SinExposicionPolitica("Sin Exposición Política");

    private final String valor;

    PoliticalExposureType(String valor) { this.valor = valor; }

    public String getValor() { return valor; }

    public static PoliticalExposureType fromValor(String valor) {
        for (PoliticalExposureType t : values()) {
            if (t.valor.equals(valor)) return t;
        }
        throw new IllegalArgumentException("Tipo de exposicion politica desconocido: " + valor);
    }
}
