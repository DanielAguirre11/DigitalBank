package com.banco.application.dto;

import com.banco.domain.model.valueobjects.PartnerProfileType;
import com.banco.domain.model.valueobjects.PoliticalExposureType;

import java.time.LocalDateTime;

public class ProfileResponse {

    private Long profileId;
    private Long partnerId;
    private PartnerProfileType profileType;
    private String description;
    private PoliticalExposureType politicalExposureType;
    private String politicalExposureDescription;
    private String salaryRange;
    private boolean employeeTerminationIndicator;
    private boolean familyMedicalInsuranceInd;
    private String educationLevel;
    private String profession;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // CONSTRUCTOR
    public ProfileResponse(Long profileId, Long partnerId, PartnerProfileType profileType, String description,
                           PoliticalExposureType politicalExposureType, String politicalExposureDescription,
                           String salaryRange, boolean employeeTerminationIndicator,
                           boolean familyMedicalInsuranceInd, String educationLevel, String profession,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.profileId = profileId;
        this.partnerId = partnerId;
        this.profileType = profileType;
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
}
