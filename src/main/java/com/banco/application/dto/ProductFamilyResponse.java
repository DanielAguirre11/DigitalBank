package com.banco.application.dto;

public class ProductFamilyResponse {

    private final Short familyId;
    private final String code;
    private final String name;
    private final String description;
    private final boolean active;


    // CONSTRUCTOR
    public ProductFamilyResponse(Short familyId, String code, String name,
                                 String description, boolean active) {
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
}
