package com.banco.application.dto;

import com.banco.domain.model.valueobjects.CivilStatusType;
import com.banco.domain.model.valueobjects.NamePrefixType;
import com.banco.domain.model.valueobjects.PartnerIdentificationType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PartnerResponse {

    private Long partnerId;
    private PartnerIdentificationType identificationType;
    private String identificationValue;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private LocalDate birthDate;
    private String nationality;
    private String residentialStatus;
    private String ethnicity;
    private String religion;
    private CivilStatusType civilStatus;
    private String jobTitle;
    private NamePrefixType namePrefix;
    private boolean state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR
    public PartnerResponse(Long partnerId, PartnerIdentificationType identificationType,
                           String identificationValue, String firstName, String middleName, String lastName,
                           String fullName, LocalDate birthDate, String nationality, String residentialStatus,
                           String ethnicity, String religion, CivilStatusType civilStatus, String jobTitle,
                           NamePrefixType namePrefix, boolean state, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.partnerId = partnerId;
        this.identificationType = identificationType;
        this.identificationValue = identificationValue;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = fullName;
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
    public String getFullName() { return fullName; }
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
}
