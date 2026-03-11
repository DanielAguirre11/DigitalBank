package com.banco.application.port.out;

import com.banco.domain.model.entities.PartnerLocation;

import java.util.List;
import java.util.Optional;

public interface PartnerLocationRepository {

    void guardar(PartnerLocation partnerLocation);

    Optional<PartnerLocation> buscarPorId(Long partnerLocationId);

    void actualizar(PartnerLocation partnerLocation);

    List<PartnerLocation> buscarPorPartnerId(Long partnerId);

    void eliminar(Long partnerLocationId);
}
