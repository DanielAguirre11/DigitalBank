package com.banco.application.dto;

import java.util.Optional;

public class ActualizarProductFamilyRequest {

    private String code;
    private String name;
    private String description;
    private Boolean active;


    // CONSTRUCTORS
    public ActualizarProductFamilyRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<String> getCode() { return Optional.ofNullable(code); }
    public void setCode(String code) { this.code = code; }

    public Optional<String> getName() { return Optional.ofNullable(name); }
    public void setName(String name) { this.name = name; }

    public Optional<String> getDescription() { return Optional.ofNullable(description); }
    public void setDescription(String description) { this.description = description; }

    public Optional<Boolean> getActive() { return Optional.ofNullable(active); }
    public void setActive(Boolean active) { this.active = active; }
}
