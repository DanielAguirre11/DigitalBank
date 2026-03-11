package com.banco.application.dto;

import com.banco.domain.model.valueobjects.CivilStatusType;
import com.banco.domain.model.valueobjects.NamePrefixType;
import com.banco.domain.model.valueobjects.PartnerIdentificationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PartnerRequest {

    @NotNull(message = "El tipo de identificacion es obligatorio")
    private PartnerIdentificationType identificationType;

    @NotBlank(message = "El valor de identificacion es obligatorio")
    @Size(max = 100, message = "El valor de identificacion no puede superar 100 caracteres")
    private String identificationValue;

    @NotBlank(message = "El primer nombre es obligatorio")
    @Size(max = 100, message = "El primer nombre no puede superar 100 caracteres")
    private String firstName;

    @Size(max = 100, message = "El segundo nombre no puede superar 100 caracteres")
    private String middleName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100, message = "El apellido no puede superar 100 caracteres")
    private String lastName;

    private LocalDate birthDate;

    @Size(max = 2, message = "La nacionalidad debe ser un codigo de pais de 2 caracteres")
    private String nationality;

    @Size(max = 50)
    private String residentialStatus;

    private String ethnicity;

    private String religion;

    private CivilStatusType civilStatus;

    @Size(max = 255)
    private String jobTitle;

    private NamePrefixType namePrefix;

    private Boolean state;


    // CONSTRUCTORS
    public PartnerRequest() {}

    public PartnerRequest(PartnerIdentificationType identificationType, String identificationValue,
                          String firstName, String middleName, String lastName, LocalDate birthDate,
                          String nationality, String residentialStatus, String ethnicity, String religion,
                          CivilStatusType civilStatus, String jobTitle, NamePrefixType namePrefix,
                          Boolean state) {
        this.identificationType = identificationType;
        this.identificationValue = identificationValue;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.residentialStatus = residentialStatus;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.civilStatus = civilStatus;
        this.jobTitle = jobTitle;
        this.namePrefix = namePrefix;
        this.state = state;
    }


    // GETTERS & SETTERS
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

    public Boolean getState() { return state; }
    public void setState(Boolean state) { this.state = state; }
}
