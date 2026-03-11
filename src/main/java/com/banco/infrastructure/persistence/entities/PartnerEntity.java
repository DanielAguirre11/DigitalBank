package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.CivilStatusType;
import com.banco.domain.model.valueobjects.NamePrefixType;
import com.banco.domain.model.valueobjects.PartnerIdentificationType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "partner")
public class PartnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_id")
    private Long partnerId;

    // Converter autoApply = true maneja la conversion al valor del enum de BD
    @Column(name = "identification_type", nullable = false, length = 50)
    private PartnerIdentificationType identificationType;

    @Column(name = "identification_value", nullable = false, length = 100)
    private String identificationValue;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    // Columna GENERATED ALWAYS AS STORED en PostgreSQL — solo lectura en JPA
    @Column(name = "full_name", insertable = false, updatable = false)
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "nationality", length = 2)
    private String nationality;

    @Column(name = "residential_status", length = 50)
    private String residentialStatus;

    @Column(name = "ethnicity")
    private String ethnicity;

    @Column(name = "religion")
    private String religion;

    // Converter autoApply = true maneja la conversion al valor del enum de BD
    @Column(name = "civil_status", length = 30)
    private CivilStatusType civilStatus;

    @Column(name = "job_title", length = 255)
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "name_prefix", length = 10)
    private NamePrefixType namePrefix;

    @Column(name = "state", nullable = false)
    private boolean state = false;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    // CONSTRUCTOR VACIO requerido por JPA
    public PartnerEntity() {}


    // GETTERS & SETTERS
    public Long getPartnerId() { return partnerId; }
    public void setPartnerId(Long partnerId) { this.partnerId = partnerId; }

    public PartnerIdentificationType getIdentificationType() { return identificationType; }
    public void setIdentificationType(PartnerIdentificationType identificationType) { this.identificationType = identificationType; }

    public String getIdentificationValue() { return identificationValue; }
    public void setIdentificationValue(String identificationValue) { this.identificationValue = identificationValue; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFullName() { return fullName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getResidentialStatus() { return residentialStatus; }
    public void setResidentialStatus(String residentialStatus) { this.residentialStatus = residentialStatus; }

    public String getEthnicity() { return ethnicity; }
    public void setEthnicity(String ethnicity) { this.ethnicity = ethnicity; }

    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }

    public CivilStatusType getCivilStatus() { return civilStatus; }
    public void setCivilStatus(CivilStatusType civilStatus) { this.civilStatus = civilStatus; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public NamePrefixType getNamePrefix() { return namePrefix; }
    public void setNamePrefix(NamePrefixType namePrefix) { this.namePrefix = namePrefix; }

    public boolean isState() { return state; }
    public void setState(boolean state) { this.state = state; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
