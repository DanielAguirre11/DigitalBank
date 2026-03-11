package com.banco.domain.model.valueobjects;

public enum PartnerProfileType {

    PerfilEducativo("Perfil Educativo"),
    PerfilLaboral("Perfil Laboral"),
    PerfilKYCRiesgo("PerfilKYC/Riesgo");

    private final String valor;

    PartnerProfileType(String valor) { this.valor = valor; }

    public String getValor() { return valor; }

    public static PartnerProfileType fromValor(String valor) {
        for (PartnerProfileType t : values()) {
            if (t.valor.equals(valor)) return t;
        }
        throw new IllegalArgumentException("Tipo de perfil desconocido: " + valor);
    }
}
