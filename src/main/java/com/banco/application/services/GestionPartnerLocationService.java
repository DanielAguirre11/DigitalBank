package com.banco.application.services;

import com.banco.application.dto.ActualizarPartnerLocationRequest;
import com.banco.application.dto.PartnerLocationRequest;
import com.banco.application.dto.PartnerLocationResponse;
import com.banco.application.port.out.PartnerLocationRepository;
import com.banco.domain.model.entities.PartnerLocation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionPartnerLocationService {

    private final PartnerLocationRepository partnerLocationRepository;

    public GestionPartnerLocationService(PartnerLocationRepository partnerLocationRepository) {
        this.partnerLocationRepository = partnerLocationRepository;
    }


    // CREAR
    public PartnerLocationResponse crearPartnerLocation(PartnerLocationRequest request) {

        PartnerLocation partnerLocation = new PartnerLocation(
            request.getPartnerId(),
            request.getPartnerLocationType(),
            request.getCountryCode(),
            request.getStateProvince(),
            request.getCity(),
            request.getAddressLine1(),
            request.getAddressLine2(),
            request.getPostalCode()
        );

        partnerLocationRepository.guardar(partnerLocation);

        return convertirResponse(partnerLocation);
    }


    // BUSCAR POR ID
    public PartnerLocationResponse buscarPartnerLocationPorId(Long partnerLocationId) {
        return convertirResponse(buscarOFallar(partnerLocationId));
    }


    // LISTAR POR PARTNER
    public List<PartnerLocationResponse> buscarPorPartnerId(Long partnerId) {
        return partnerLocationRepository.buscarPorPartnerId(partnerId)
            .stream()
            .map(this::convertirResponse)
            .collect(Collectors.toList());
    }


    // ACTUALIZAR
    public PartnerLocationResponse actualizarPartnerLocation(Long partnerLocationId,
                                                             ActualizarPartnerLocationRequest request) {

        PartnerLocation partnerLocation = buscarOFallar(partnerLocationId);

        request.getPartnerLocationType().ifPresent(partnerLocation::setPartnerLocationType);
        request.getCountryCode().ifPresent(partnerLocation::setCountryCode);
        request.getStateProvince().ifPresent(partnerLocation::setStateProvince);
        request.getCity().ifPresent(partnerLocation::setCity);
        request.getAddressLine1().ifPresent(partnerLocation::setAddressLine1);
        request.getAddressLine2().ifPresent(partnerLocation::setAddressLine2);
        request.getPostalCode().ifPresent(partnerLocation::setPostalCode);

        partnerLocationRepository.actualizar(partnerLocation);

        return convertirResponse(partnerLocation);
    }


    // ELIMINAR
    public void eliminarPartnerLocation(Long partnerLocationId) {
        buscarOFallar(partnerLocationId);
        partnerLocationRepository.eliminar(partnerLocationId);
    }


    // CONVERSION DOMINIO → RESPONSE
    public PartnerLocationResponse convertirResponse(PartnerLocation partnerLocation) {
        return new PartnerLocationResponse(
            partnerLocation.getPartnerLocationId(),
            partnerLocation.getPartnerId(),
            partnerLocation.getPartnerLocationType(),
            partnerLocation.getCountryCode(),
            partnerLocation.getStateProvince(),
            partnerLocation.getCity(),
            partnerLocation.getAddressLine1(),
            partnerLocation.getAddressLine2(),
            partnerLocation.getPostalCode(),
            partnerLocation.getCreatedAt(),
            partnerLocation.getUpdatedAt()
        );
    }


    // PRIVADOS
    private PartnerLocation buscarOFallar(Long partnerLocationId) {
        return partnerLocationRepository.buscarPorId(partnerLocationId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la ubicacion del partner con id: " + partnerLocationId));
    }
}
