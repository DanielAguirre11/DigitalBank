package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.PartnerRepository;
import com.banco.domain.model.entities.Partner;
import com.banco.domain.model.valueobjects.PartnerIdentificationType;
import com.banco.infrastructure.persistence.entities.PartnerEntity;
import com.banco.infrastructure.persistence.jpa.Interface.PartnerJpaRepository;
import com.banco.infrastructure.persistence.mappers.PartnerMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class PartnerRepositoryJpa implements PartnerRepository {

    private final PartnerJpaRepository partnerJpaRepository;
    private final PartnerMapper partnerMapper;

    public PartnerRepositoryJpa(PartnerJpaRepository partnerJpaRepository, PartnerMapper partnerMapper) {
        this.partnerJpaRepository = partnerJpaRepository;
        this.partnerMapper = partnerMapper;
    }


    @Override
    public void guardar(Partner partner) {
        PartnerEntity entity = partnerMapper.aEntity(partner, null);
        PartnerEntity saved = partnerJpaRepository.save(entity);
        partner.setPartnerId(saved.getPartnerId());
    }

    @Override
    public Optional<Partner> buscarPorId(Long partnerId) {
        return partnerJpaRepository.findById(partnerId)
            .map(partnerMapper::aDominio);
    }

    @Override
    public void actualizar(Partner partner) {
        PartnerEntity existing = partnerJpaRepository.findById(partner.getPartnerId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el partner con id: " + partner.getPartnerId()));
        partnerMapper.aEntity(partner, existing);
        partnerJpaRepository.save(existing);
    }

    @Override
    public List<Partner> buscarTodos() {
        return partnerJpaRepository.findAll()
            .stream()
            .map(partnerMapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long partnerId) {
        partnerJpaRepository.deleteById(partnerId);
    }

    @Override
    public boolean existePorIdentificacion(PartnerIdentificationType type, String value) {
        return partnerJpaRepository.existsByIdentificationTypeAndIdentificationValue(type, value);
    }

    @Override
    public boolean existePorIdentificacionExcluyendo(PartnerIdentificationType type, String value, Long partnerId) {
        return partnerJpaRepository.existsByIdentificationTypeAndIdentificationValueAndPartnerIdNot(
            type, value, partnerId);
    }
}
