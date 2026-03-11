package com.banco.application.port.out;

import com.banco.domain.model.entities.ContactPoint;

import java.util.List;
import java.util.Optional;

public interface ContactPointRepository {

    void guardar(ContactPoint contactPoint);

    Optional<ContactPoint> buscarPorId(Long contactPointId);

    void actualizar(ContactPoint contactPoint);

    List<ContactPoint> buscarPorPartyId(Integer partyId);

    void eliminar(Long contactPointId);
}
