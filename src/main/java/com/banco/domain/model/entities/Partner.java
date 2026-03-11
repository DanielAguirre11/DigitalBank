package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.CivilStatusType;
import com.banco.domain.model.valueobjects.NamePrefixType;
import com.banco.domain.model.valueobjects.PartnerIdentificationType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Partner {

    // ATRIBUTOS
    private Long partnerId;
    private final PartnerIdentificationType identificationType;
    private final String identificationValue;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private String residentialStatus;
    private String ethnicity;
    private String religion;
    private CivilStatusType civilStatus;
    private String jobTitle;
    private NamePrefixType namePrefix;
    private boolean state;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR PARA CREAR (sin partnerId ni timestamps — los genera la BD)
    public Partner(PartnerIdentificationType identificationType, String identificationValue,
                   String firstName, String middleName, String lastName, LocalDate birthDate,
                   String nationality, String residentialStatus, String ethnicity, String religion,
                   CivilStatusType civilStatus, String jobTitle, NamePrefixType namePrefix) {

        this.identificationType = Objects.requireNonNull(identificationType, "El tipo de identificacion no puede ser nulo");
        this.identificationValue = Objects.requireNonNull(identificationValue, "El valor de identificacion no puede ser nulo");
        this.firstName = Objects.requireNonNull(firstName, "El primer nombre no puede ser nulo");
        this.middleName = middleName;
        this.lastName = Objects.requireNonNull(lastName, "El apellido no puede ser nulo");
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.residentialStatus = residentialStatus;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.civilStatus = civilStatus;
        this.jobTitle = jobTitle;
        this.namePrefix = namePrefix;
        this.state = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    // CONSTRUCTOR PARA RECONSTRUIR DESDE BD (incluye partnerId y timestamps)
    public Partner(Long partnerId, PartnerIdentificationType identificationType,
                   String identificationValue, String firstName, String middleName, String lastName,
                   LocalDate birthDate, String nationality, String residentialStatus, String ethnicity,
                   String religion, CivilStatusType civilStatus, String jobTitle, NamePrefixType namePrefix,
                   boolean state, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.partnerId = partnerId;
        this.identificationType = Objects.requireNonNull(identificationType, "El tipo de identificacion no puede ser nulo");
        this.identificationValue = Objects.requireNonNull(identificationValue, "El valor de identificacion no puede ser nulo");
        this.firstName = Objects.requireNonNull(firstName, "El primer nombre no puede ser nulo");
        this.middleName = middleName;
        this.lastName = Objects.requireNonNull(lastName, "El apellido no puede ser nulo");
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.residentialStatus = residentialStatus;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.civilStatus = civilStatus;
        this.jobTitle = jobTitle;
        this.namePrefix = namePrefix;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    // GETTERS
    public Long getPartnerId() { return partnerId; }
    public PartnerIdentificationType getIdentificationType() { return identificationType; }
    public String getIdentificationValue() { return identificationValue; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getNationality() { return nationality; }
    public String getResidentialStatus() { return residentialStatus; }
    public String getEthnicity() { return ethnicity; }
    public String getReligion() { return religion; }
    public CivilStatusType getCivilStatus() { return civilStatus; }
    public String getJobTitle() { return jobTitle; }
    public NamePrefixType getNamePrefix() { return namePrefix; }
    public boolean isState() { return state; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // Nombre completo calculado (espeja la columna GENERATED del esquema)
    public String getFullName() {
        StringBuilder sb = new StringBuilder(firstName);
        if (middleName != null && !middleName.isBlank()) {
            sb.append(" ").append(middleName);
        }
        sb.append(" ").append(lastName);
        return sb.toString();
    }


    // SETTERS (campos mutables)
    public void setPartnerId(Long partnerId) { this.partnerId = partnerId; }
    public void setFirstName(String firstName) { this.firstName = Objects.requireNonNull(firstName); }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = Objects.requireNonNull(lastName); }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public void setResidentialStatus(String residentialStatus) { this.residentialStatus = residentialStatus; }
    public void setEthnicity(String ethnicity) { this.ethnicity = ethnicity; }
    public void setReligion(String religion) { this.religion = religion; }
    public void setCivilStatus(CivilStatusType civilStatus) { this.civilStatus = civilStatus; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setNamePrefix(NamePrefixType namePrefix) { this.namePrefix = namePrefix; }
    public void setState(boolean state) { this.state = state; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
