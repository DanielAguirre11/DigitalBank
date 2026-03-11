package com.banco.infrastructure.persistence.mappers;

import com.banco.domain.model.entities.Profile;
import com.banco.infrastructure.persistence.entities.ProfileEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    // ENTITY → DOMINIO
    public Profile aDominio(ProfileEntity entity) {
        return new Profile(
            entity.getProfileId(),
            entity.getPartnerId(),
            entity.getProfileType(),
            entity.getDescription(),
            entity.getPoliticalExposureType(),
            entity.getPoliticalExposureDescription(),
            entity.getSalaryRange(),
            entity.isEmployeeTerminationIndicator(),
            entity.isFamilyMedicalInsuranceInd(),
            entity.getEducationLevel(),
            entity.getProfession(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    // DOMINIO → ENTITY
    public ProfileEntity aEntity(Profile dominio, ProfileEntity entityExistente) {

        if (entityExistente == null) {
            entityExistente = new ProfileEntity();
        }

        entityExistente.setPartnerId(dominio.getPartnerId());
        entityExistente.setProfileType(dominio.getProfileType());
        entityExistente.setDescription(dominio.getDescription());
        entityExistente.setPoliticalExposureType(dominio.getPoliticalExposureType());
        entityExistente.setPoliticalExposureDescription(dominio.getPoliticalExposureDescription());
        entityExistente.setSalaryRange(dominio.getSalaryRange());
        entityExistente.setEmployeeTerminationIndicator(dominio.isEmployeeTerminationIndicator());
        entityExistente.setFamilyMedicalInsuranceInd(dominio.isFamilyMedicalInsuranceInd());
        entityExistente.setEducationLevel(dominio.getEducationLevel());
        entityExistente.setProfession(dominio.getProfession());

        return entityExistente;
    }
}
