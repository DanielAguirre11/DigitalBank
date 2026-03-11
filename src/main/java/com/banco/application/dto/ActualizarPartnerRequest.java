package com.banco.application.dto;

import com.banco.domain.model.valueobjects.CivilStatusType;
import com.banco.domain.model.valueobjects.NamePrefixType;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Optional;

public class ActualizarPartnerRequest {

    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String middleName;

    @Size(max = 100)
    private String lastName;

    private LocalDate birthDate;

    @Size(max = 2)
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
    public ActualizarPartnerRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<String> getFirstName() { return Optional.ofNullable(firstName); }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public Optional<String> getMiddleName() { return Optional.ofNullable(middleName); }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public Optional<String> getLastName() { return Optional.ofNullable(lastName); }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Optional<LocalDate> getBirthDate() { return Optional.ofNullable(birthDate); }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Optional<String> getNationality() { return Optional.ofNullable(nationality); }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public Optional<String> getResidentialStatus() { return Optional.ofNullable(residentialStatus); }
    public void setResidentialStatus(String residentialStatus) { this.residentialStatus = residentialStatus; }

    public Optional<String> getEthnicity() { return Optional.ofNullable(ethnicity); }
    public void setEthnicity(String ethnicity) { this.ethnicity = ethnicity; }

    public Optional<String> getReligion() { return Optional.ofNullable(religion); }
    public void setReligion(String religion) { this.religion = religion; }

    public Optional<CivilStatusType> getCivilStatus() { return Optional.ofNullable(civilStatus); }
    public void setCivilStatus(CivilStatusType civilStatus) { this.civilStatus = civilStatus; }

    public Optional<String> getJobTitle() { return Optional.ofNullable(jobTitle); }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public Optional<NamePrefixType> getNamePrefix() { return Optional.ofNullable(namePrefix); }
    public void setNamePrefix(NamePrefixType namePrefix) { this.namePrefix = namePrefix; }

    public Optional<Boolean> getState() { return Optional.ofNullable(state); }
    public void setState(Boolean state) { this.state = state; }
}
