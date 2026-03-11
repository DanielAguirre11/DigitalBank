package com.banco.infrastructure.persistence.entities;

import com.banco.domain.model.valueobjects.PartnerProfileType;
import com.banco.domain.model.valueobjects.PoliticalExposureType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "partner_id", nullable = false)
    private Long partnerId;

    // Converter autoApply = true maneja la conversion al valor del enum de BD
    @Column(name = "profile_type", nullable = false, length = 50)
    private PartnerProfileType profileType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Converter autoApply = true maneja la conversion al valor del enum de BD
    @Column(name = "political_exposure_type", length = 50)
    private PoliticalExposureType politicalExposureType;

    @Column(name = "political_exposure_description", columnDefinition = "TEXT")
    private String politicalExposureDescription;

    @Column(name = "salary_range", length = 50)
    private String salaryRange;

    @Column(name = "employee_termination_indicator")
    private boolean employeeTerminationIndicator;

    @Column(name = "family_medical_insurance_ind")
    private boolean familyMedicalInsuranceInd;

    @Column(name = "education_level", length = 100)
    private String educationLevel;

    @Column(name = "profession", length = 100)
    private String profession;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    // CONSTRUCTOR VACIO requerido por JPA
    public ProfileEntity() {}


    // GETTERS & SETTERS
    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }

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

    public boolean isEmployeeTerminationIndicator() { return employeeTerminationIndicator; }
    public void setEmployeeTerminationIndicator(boolean employeeTerminationIndicator) { this.employeeTerminationIndicator = employeeTerminationIndicator; }

    public boolean isFamilyMedicalInsuranceInd() { return familyMedicalInsuranceInd; }
    public void setFamilyMedicalInsuranceInd(boolean familyMedicalInsuranceInd) { this.familyMedicalInsuranceInd = familyMedicalInsuranceInd; }

    public String getEducationLevel() { return educationLevel; }
    public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
