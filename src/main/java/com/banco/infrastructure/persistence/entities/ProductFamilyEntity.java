package com.banco.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_family", schema = "products")
public class ProductFamilyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    private Short familyId;

    @Column(name = "code", nullable = false, length = 20, unique = true)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "active", nullable = false)
    private boolean active = true;


    // CONSTRUCTOR VACIO requerido por JPA
    public ProductFamilyEntity() {}


    // GETTERS & SETTERS
    public Short getFamilyId() { return familyId; }
    public void setFamilyId(Short familyId) { this.familyId = familyId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
