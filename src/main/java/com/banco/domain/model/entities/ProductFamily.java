package com.banco.domain.model.entities;

public class ProductFamily {

    private Short familyId;
    private String code;
    private String name;
    private String description;
    private boolean active;

    // Constructor for create (no ID yet)
    public ProductFamily(String code, String name, String description, boolean active) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    // Constructor for reconstruct from DB (all fields)
    public ProductFamily(Short familyId, String code, String name, String description, boolean active) {
        this.familyId = familyId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    // GETTERS
    public Short getFamilyId() { return familyId; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isActive() { return active; }

    // SETTERS
    public void setFamilyId(Short familyId) { this.familyId = familyId; }
    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(boolean active) { this.active = active; }
}
