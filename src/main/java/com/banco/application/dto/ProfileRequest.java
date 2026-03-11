package com.banco.application.dto;

import com.banco.domain.model.valueobjects.PartnerProfileType;
import com.banco.domain.model.valueobjects.PoliticalExposureType;
import jakarta.validation.constraints.NotNull;

public class ProfileRequest {

    @NotNull(message = "El id del partner es obligatorio")
    private Long partnerId;

    @NotNull(message = "El tipo de perfil es obligatorio")
    private PartnerProfileType profileType;

    private String description;

    private PoliticalExposureType politicalExposureType;

    private String politicalExposureDescription;

    private String salaryRange;

    private Boolean employeeTerminationIndicator;

    private Boolean familyMedicalInsuranceInd;

    private String educationLevel;

    private String profession;


    // CONSTRUCTORS
    public ProfileRequest() {}

    public ProfileRequest(Long partnerId, PartnerProfileType profileType, String description,
                          PoliticalExposureType politicalExposureType, String politicalExposureDescription,
                          String salaryRange, Boolean employeeTerminationIndicator,
                          Boolean familyMedicalInsuranceInd, String educationLevel, String profession) {
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
    }


    // GETTERS & SETTERS
    public Long getPartnerId() { return partnerId; }
    public void setPartnerId(Long partnerId) { this.partnerId = partnerId; }

    public PartnerProfileType getProfileType() { return profileType; }
    public void setProfileType(PartnerProfileType profileType) { this.profileType = profileType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public PoliticalExposureType getPoliticalExposureType() { return politicalExposureType; }
    public void setPoliticalExposureType(PoliticalExposureType politicalExposureType) { this.politicalExposureType = politicalExposureType; }

    public String getPoliticalExposureDescription() { return politicalExposureDescription; }
    public void setPoliticalExposureDescription(String politicalExposureDescription) { this.politicalExposureDescription = politicalExposureDescription; }

    public String getSalaryRange() { return salaryRange; }
    public void setSalaryRange(String salaryRange) { this.salaryRange = salaryRange; }

    public Boolean getEmployeeTerminationIndicator() { return employeeTerminationIndicator; }
    public void setEmployeeTerminationIndicator(Boolean employeeTerminationIndicator) { this.employeeTerminationIndicator = employeeTerminationIndicator; }

    public Boolean getFamilyMedicalInsuranceInd() { return familyMedicalInsuranceInd; }
    public void setFamilyMedicalInsuranceInd(Boolean familyMedicalInsuranceInd) { this.familyMedicalInsuranceInd = familyMedicalInsuranceInd; }

    public String getEducationLevel() { return educationLevel; }
    public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }
}
