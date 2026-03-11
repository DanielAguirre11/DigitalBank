package com.banco.domain.model.entities;

import com.banco.domain.model.valueobjects.PartnerProfileType;
import com.banco.domain.model.valueobjects.PoliticalExposureType;

import java.time.LocalDateTime;
import java.util.Objects;

public class Profile {

    private Long profileId;
    private final Long partnerId;
    private final PartnerProfileType profileType;
    private String description;
    private PoliticalExposureType politicalExposureType;
    private String politicalExposureDescription;
    private String salaryRange;
    private boolean employeeTerminationIndicator;
    private boolean familyMedicalInsuranceInd;
    private String educationLevel;
    private String profession;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR PARA CREAR
    public Profile(Long partnerId, PartnerProfileType profileType, String description,
                   PoliticalExposureType politicalExposureType, String politicalExposureDescription,
                   String salaryRange, boolean employeeTerminationIndicator,
                   boolean familyMedicalInsuranceInd, String educationLevel, String profession) {
        this.partnerId = Objects.requireNonNull(partnerId, "El partnerId no puede ser nulo");
        this.profileType = Objects.requireNonNull(profileType, "El tipo de perfil no puede ser nulo");
        this.description = description;
        this.politicalExposureType = politicalExposureType;
        this.politicalExposureDescription = politicalExposureDescription;
        this.salaryRange = salaryRange;
        this.employeeTerminationIndicator = employeeTerminationIndicator;
        this.familyMedicalInsuranceInd = familyMedicalInsuranceInd;
        this.educationLevel = educationLevel;
        this.profession = profession;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // CONSTRUCTOR PARA RECONSTRUIR DESDE BD
    public Profile(Long profileId, Long partnerId, PartnerProfileType profileType, String description,
                   PoliticalExposureType politicalExposureType, String politicalExposureDescription,
                   String salaryRange, boolean employeeTerminationIndicator,
                   boolean familyMedicalInsuranceInd, String educationLevel, String profession,
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.profileId = profileId;
        this.partnerId = Objects.requireNonNull(partnerId, "El partnerId no puede ser nulo");
        this.profileType = Objects.requireNonNull(profileType, "El tipo de perfil no puede ser nulo");
        this.description = description;
        this.politicalExposureType = politicalExposureType;
        this.politicalExposureDescription = politicalExposureDescription;
        this.salaryRange = salaryRange;
        this.employeeTerminationIndicator = employeeTerminationIndicator;
        this.familyMedicalInsuranceInd = familyMedicalInsuranceInd;
        this.educationLevel = educationLevel;
        this.profession = profession;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // GETTERS
    public Long getProfileId() { return profileId; }
    public Long getPartnerId() { return partnerId; }
    public PartnerProfileType getProfileType() { return profileType; }
    public String getDescription() { return description; }
    public PoliticalExposureType getPoliticalExposureType() { return politicalExposureType; }
    public String getPoliticalExposureDescription() { return politicalExposureDescription; }
    public String getSalaryRange() { return salaryRange; }
    public boolean isEmployeeTerminationIndicator() { return employeeTerminationIndicator; }
    public boolean isFamilyMedicalInsuranceInd() { return familyMedicalInsuranceInd; }
    public String getEducationLevel() { return educationLevel; }
    public String getProfession() { return profession; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // SETTERS
    public void setProfileId(Long profileId) { this.profileId = profileId; }
    public void setDescription(String description) { this.description = description; }
    public void setPoliticalExposureType(PoliticalExposureType politicalExposureType) { this.politicalExposureType = politicalExposureType; }
    public void setPoliticalExposureDescription(String politicalExposureDescription) { this.politicalExposureDescription = politicalExposureDescription; }
    public void setSalaryRange(String salaryRange) { this.salaryRange = salaryRange; }
    public void setEmployeeTerminationIndicator(boolean employeeTerminationIndicator) { this.employeeTerminationIndicator = employeeTerminationIndicator; }
    public void setFamilyMedicalInsuranceInd(boolean familyMedicalInsuranceInd) { this.familyMedicalInsuranceInd = familyMedicalInsuranceInd; }
    public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }
    public void setProfession(String profession) { this.profession = profession; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
