package com.banco.application.services;

import com.banco.application.dto.ActualizarProfileRequest;
import com.banco.application.dto.ProfileRequest;
import com.banco.application.dto.ProfileResponse;
import com.banco.application.port.out.ProfileRepository;
import com.banco.domain.model.entities.Profile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionProfileService {

    private final ProfileRepository profileRepository;

    public GestionProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    // CREAR
    public ProfileResponse crearProfile(ProfileRequest request) {

        boolean empTermination = request.getEmployeeTerminationIndicator() != null
            && request.getEmployeeTerminationIndicator();
        boolean familyMedical = request.getFamilyMedicalInsuranceInd() != null
            && request.getFamilyMedicalInsuranceInd();

        Profile profile = new Profile(
            request.getPartnerId(),
            request.getProfileType(),
            request.getDescription(),
            request.getPoliticalExposureType(),
            request.getPoliticalExposureDescription(),
            request.getSalaryRange(),
            empTermination,
            familyMedical,
            request.getEducationLevel(),
            request.getProfession()
        );

        profileRepository.guardar(profile);

        return convertirResponse(profile);
    }


    // BUSCAR POR ID
    public ProfileResponse buscarProfilePorId(Long profileId) {
        return convertirResponse(buscarOFallar(profileId));
    }


    // LISTAR POR PARTNER
    public List<ProfileResponse> buscarPorPartnerId(Long partnerId) {
        return profileRepository.buscarPorPartnerId(partnerId)
            .stream()
            .map(this::convertirResponse)
            .collect(Collectors.toList());
    }


    // ACTUALIZAR
    public ProfileResponse actualizarProfile(Long profileId, ActualizarProfileRequest request) {

        Profile profile = buscarOFallar(profileId);

        request.getDescription().ifPresent(profile::setDescription);
        request.getPoliticalExposureType().ifPresent(profile::setPoliticalExposureType);
        request.getPoliticalExposureDescription().ifPresent(profile::setPoliticalExposureDescription);
        request.getSalaryRange().ifPresent(profile::setSalaryRange);
        request.getEmployeeTerminationIndicator().ifPresent(profile::setEmployeeTerminationIndicator);
        request.getFamilyMedicalInsuranceInd().ifPresent(profile::setFamilyMedicalInsuranceInd);
        request.getEducationLevel().ifPresent(profile::setEducationLevel);
        request.getProfession().ifPresent(profile::setProfession);

        profileRepository.actualizar(profile);

        return convertirResponse(profile);
    }


    // ELIMINAR
    public void eliminarProfile(Long profileId) {
        buscarOFallar(profileId);
        profileRepository.eliminar(profileId);
    }


    // CONVERSION DOMINIO → RESPONSE
    public ProfileResponse convertirResponse(Profile profile) {
        return new ProfileResponse(
            profile.getProfileId(),
            profile.getPartnerId(),
            profile.getProfileType(),
            profile.getDescription(),
            profile.getPoliticalExposureType(),
            profile.getPoliticalExposureDescription(),
            profile.getSalaryRange(),
            profile.isEmployeeTerminationIndicator(),
            profile.isFamilyMedicalInsuranceInd(),
            profile.getEducationLevel(),
            profile.getProfession(),
            profile.getCreatedAt(),
            profile.getUpdatedAt()
        );
    }


    // PRIVADOS
    private Profile buscarOFallar(Long profileId) {
        return profileRepository.buscarPorId(profileId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el perfil con id: " + profileId));
    }
}
