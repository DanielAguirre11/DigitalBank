package com.banco.application.port.out;

import com.banco.domain.model.entities.Partner;
import com.banco.domain.model.valueobjects.PartnerIdentificationType;

import java.util.List;
import java.util.Optional;

public interface PartnerRepository {

    void guardar(Partner partner);

    Optional<Partner> buscarPorId(Long partnerId);

    void actualizar(Partner partner);

    List<Partner> buscarTodos();

    void eliminar(Long partnerId);

    boolean existePorIdentificacion(PartnerIdentificationType type, String value);

    boolean existePorIdentificacionExcluyendo(PartnerIdentificationType type, String value, Long partnerId);
}
