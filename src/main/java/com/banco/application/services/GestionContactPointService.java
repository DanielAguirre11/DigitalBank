package com.banco.application.services;

import com.banco.application.dto.ActualizarContactPointRequest;
import com.banco.application.dto.ContactPointRequest;
import com.banco.application.dto.ContactPointResponse;
import com.banco.application.port.out.ContactPointRepository;
import com.banco.domain.model.entities.ContactPoint;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionContactPointService {

    private final ContactPointRepository contactPointRepository;

    public GestionContactPointService(ContactPointRepository contactPointRepository) {
        this.contactPointRepository = contactPointRepository;
    }


    // CREAR
    public ContactPointResponse crearContactPoint(ContactPointRequest request) {

        ContactPoint contactPoint = new ContactPoint(
            request.getPartyId(),
            request.getContactPointType(),
            request.getContactValue(),
            request.isPrimary(),
            request.getValidFrom(),
            request.getValidTo()
        );

        contactPointRepository.guardar(contactPoint);

        return convertirResponse(contactPoint);
    }


    // BUSCAR POR ID
    public ContactPointResponse buscarContactPointPorId(Long contactPointId) {
        return convertirResponse(buscarOFallar(contactPointId));
    }


    // LISTAR POR PARTY
    public List<ContactPointResponse> buscarPorPartyId(Integer partyId) {
        return contactPointRepository.buscarPorPartyId(partyId)
            .stream()
            .map(this::convertirResponse)
            .collect(Collectors.toList());
    }


    // ACTUALIZAR
    public ContactPointResponse actualizarContactPoint(Long contactPointId,
                                                       ActualizarContactPointRequest request) {

        ContactPoint contactPoint = buscarOFallar(contactPointId);

        request.getContactValue().ifPresent(contactPoint::setContactValue);
        request.getPrimary().ifPresent(contactPoint::setPrimary);
        request.getValidFrom().ifPresent(contactPoint::setValidFrom);
        request.getValidTo().ifPresent(contactPoint::setValidTo);

        contactPointRepository.actualizar(contactPoint);

        return convertirResponse(contactPoint);
    }


    // ELIMINAR
    public void eliminarContactPoint(Long contactPointId) {
        buscarOFallar(contactPointId);
        contactPointRepository.eliminar(contactPointId);
    }


    // CONVERSION DOMINIO → RESPONSE
    public ContactPointResponse convertirResponse(ContactPoint contactPoint) {
        return new ContactPointResponse(
            contactPoint.getContactPointId(),
            contactPoint.getPartyId(),
            contactPoint.getContactPointType(),
            contactPoint.getContactValue(),
            contactPoint.isPrimary(),
            contactPoint.getValidFrom(),
            contactPoint.getValidTo(),
            contactPoint.getCreatedAt(),
            contactPoint.getUpdatedAt()
        );
    }


    // PRIVADOS
    private ContactPoint buscarOFallar(Long contactPointId) {
        return contactPointRepository.buscarPorId(contactPointId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el punto de contacto con id: " + contactPointId));
    }
}
