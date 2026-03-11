package com.banco.application.port.out;

import com.banco.domain.model.entities.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {

    void guardar(Profile profile);

    Optional<Profile> buscarPorId(Long profileId);

    void actualizar(Profile profile);

    List<Profile> buscarPorPartnerId(Long partnerId);

    void eliminar(Long profileId);
}
