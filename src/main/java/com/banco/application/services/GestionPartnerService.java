package com.banco.application.services;

import com.banco.application.dto.ActualizarPartnerRequest;
import com.banco.application.dto.PartnerRequest;
import com.banco.application.dto.PartnerResponse;
import com.banco.application.port.out.PartnerRepository;
import com.banco.domain.model.entities.Partner;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionPartnerService {

    private final PartnerRepository partnerRepository;

    public GestionPartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }


    // CREAR
    public PartnerResponse crearPartner(PartnerRequest request) {

        validarIdentificacionNueva(request);

        Partner partner = new Partner(
            request.getIdentificationType(),
            request.getIdentificationValue(),
            request.getFirstName(),
            request.getMiddleName(),
            request.getLastName(),
            request.getBirthDate(),
            request.getNationality(),
            request.getResidentialStatus(),
            request.getEthnicity(),
            request.getReligion(),
            request.getCivilStatus(),
            request.getJobTitle(),
            request.getNamePrefix()
        );

        partnerRepository.guardar(partner);

        return convertirResponse(partner);
    }


    // BUSCAR POR ID
    public PartnerResponse buscarPartnerPorId(Long partnerId) {
        return convertirResponse(buscarOFallar(partnerId));
    }


    // LISTAR TODOS
    public List<PartnerResponse> buscarTodos() {
        return partnerRepository.buscarTodos()
            .stream()
            .map(this::convertirResponse)
            .collect(Collectors.toList());
    }


    // ACTUALIZAR
    public PartnerResponse actualizarPartner(Long partnerId, ActualizarPartnerRequest request) {

        Partner partner = buscarOFallar(partnerId);

        request.getFirstName().ifPresent(partner::setFirstName);
        request.getMiddleName().ifPresent(partner::setMiddleName);
        request.getLastName().ifPresent(partner::setLastName);
        request.getBirthDate().ifPresent(partner::setBirthDate);
        request.getNationality().ifPresent(partner::setNationality);
        request.getResidentialStatus().ifPresent(partner::setResidentialStatus);
        request.getEthnicity().ifPresent(partner::setEthnicity);
        request.getReligion().ifPresent(partner::setReligion);
        request.getCivilStatus().ifPresent(partner::setCivilStatus);
        request.getJobTitle().ifPresent(partner::setJobTitle);
        request.getNamePrefix().ifPresent(partner::setNamePrefix);
        request.getState().ifPresent(partner::setState);

        partnerRepository.actualizar(partner);

        return convertirResponse(partner);
    }


    // ELIMINAR
    public void eliminarPartner(Long partnerId) {
        buscarOFallar(partnerId);
        partnerRepository.eliminar(partnerId);
    }


    // CONVERSION DOMINIO → RESPONSE
    public PartnerResponse convertirResponse(Partner partner) {
        return new PartnerResponse(
            partner.getPartnerId(),
            partner.getIdentificationType(),
            partner.getIdentificationValue(),
            partner.getFirstName(),
            partner.getMiddleName(),
            partner.getLastName(),
            partner.getFullName(),
            partner.getBirthDate(),
            partner.getNationality(),
            partner.getResidentialStatus(),
            partner.getEthnicity(),
            partner.getReligion(),
            partner.getCivilStatus(),
            partner.getJobTitle(),
            partner.getNamePrefix(),
            partner.isState(),
            partner.getCreatedAt(),
            partner.getUpdatedAt()
        );
    }


    // PRIVADOS
    private void validarIdentificacionNueva(PartnerRequest request) {
        if (partnerRepository.existePorIdentificacion(
                request.getIdentificationType(), request.getIdentificationValue())) {
            throw new IllegalArgumentException(
                "Ya existe un partner con " + request.getIdentificationType()
                + ": " + request.getIdentificationValue());
        }
    }

    private Partner buscarOFallar(Long partnerId) {
        return partnerRepository.buscarPorId(partnerId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el partner con id: " + partnerId));
    }
}
