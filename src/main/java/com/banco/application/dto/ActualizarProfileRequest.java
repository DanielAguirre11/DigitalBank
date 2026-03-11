package com.banco.application.dto;

import com.banco.domain.model.valueobjects.PoliticalExposureType;

import java.util.Optional;

public class ActualizarProfileRequest {

    private String description;

    private PoliticalExposureType politicalExposureType;

    private String politicalExposureDescription;

    private String salaryRange;

    private Boolean employeeTerminationIndicator;

    private Boolean familyMedicalInsuranceInd;

    private String educationLevel;

    private String profession;


    // CONSTRUCTORS
    public ActualizarProfileRequest() {}


    // GETTERS devuelven Optional para distinguir null intencional de "no enviado"
    public Optional<String> getDescription() { return Optional.ofNullable(description); }
    public void setDescription(String description) { this.description = description; }

    public Optional<PoliticalExposureType> getPoliticalExposureType() { return Optional.ofNullable(politicalExposureType); }
    public void setPoliticalExposureType(PoliticalExposureType politicalExposureType) { this.politicalExposureType = politicalExposureType; }

    public Optional<String> getPoliticalExposureDescription() { return Optional.ofNullable(politicalExposureDescription); }
    public void setPoliticalExposureDescription(String politicalExposureDescription) { this.politicalExposureDescription = politicalExposureDescription; }

    public Optional<String> getSalaryRange() { return Optional.ofNullable(salaryRange); }
    public void setSalaryRange(String salaryRange) { this.salaryRange = salaryRange; }

    public Optional<Boolean> getEmployeeTerminationIndicator() { return Optional.ofNullable(employeeTerminationIndicator); }
    public void setEmployeeTerminationIndicator(Boolean employeeTerminationIndicator) { this.employeeTerminationIndicator = employeeTerminationIndicator; }

    public Optional<Boolean> getFamilyMedicalInsuranceInd() { return Optional.ofNullable(familyMedicalInsuranceInd); }
    public void setFamilyMedicalInsuranceInd(Boolean familyMedicalInsuranceInd) { this.familyMedicalInsuranceInd = familyMedicalInsuranceInd; }

    public Optional<String> getEducationLevel() { return Optional.ofNullable(educationLevel); }
    public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }

    public Optional<String> getProfession() { return Optional.ofNullable(profession); }
    public void setProfession(String profession) { this.profession = profession; }
}
