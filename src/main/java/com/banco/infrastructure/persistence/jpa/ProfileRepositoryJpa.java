package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.ProfileRepository;
import com.banco.domain.model.entities.Profile;
import com.banco.infrastructure.persistence.entities.ProfileEntity;
import com.banco.infrastructure.persistence.jpa.Interface.ProfileJpaRepository;
import com.banco.infrastructure.persistence.mappers.ProfileMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProfileRepositoryJpa implements ProfileRepository {

    private final ProfileJpaRepository profileJpaRepository;
    private final ProfileMapper profileMapper;

    public ProfileRepositoryJpa(ProfileJpaRepository profileJpaRepository, ProfileMapper profileMapper) {
        this.profileJpaRepository = profileJpaRepository;
        this.profileMapper = profileMapper;
    }


    @Override
    public void guardar(Profile profile) {
        ProfileEntity entity = profileMapper.aEntity(profile, null);
        ProfileEntity saved = profileJpaRepository.save(entity);
        profile.setProfileId(saved.getProfileId());
    }

    @Override
    public Optional<Profile> buscarPorId(Long profileId) {
        return profileJpaRepository.findById(profileId)
            .map(profileMapper::aDominio);
    }

    @Override
    public void actualizar(Profile profile) {
        ProfileEntity existing = profileJpaRepository.findById(profile.getProfileId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el perfil con id: " + profile.getProfileId()));
        profileMapper.aEntity(profile, existing);
        profileJpaRepository.save(existing);
    }

    @Override
    public List<Profile> buscarPorPartnerId(Long partnerId) {
        return profileJpaRepository.findByPartnerId(partnerId)
            .stream()
            .map(profileMapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long profileId) {
        profileJpaRepository.deleteById(profileId);
    }
}
