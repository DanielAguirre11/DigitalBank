package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.PartnerLocationRepository;
import com.banco.domain.model.entities.PartnerLocation;
import com.banco.infrastructure.persistence.entities.PartnerLocationEntity;
import com.banco.infrastructure.persistence.jpa.Interface.PartnerLocationJpaRepository;
import com.banco.infrastructure.persistence.mappers.PartnerLocationMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class PartnerLocationRepositoryJpa implements PartnerLocationRepository {

    private final PartnerLocationJpaRepository partnerLocationJpaRepository;
    private final PartnerLocationMapper partnerLocationMapper;

    public PartnerLocationRepositoryJpa(PartnerLocationJpaRepository partnerLocationJpaRepository,
                                        PartnerLocationMapper partnerLocationMapper) {
        this.partnerLocationJpaRepository = partnerLocationJpaRepository;
        this.partnerLocationMapper = partnerLocationMapper;
    }


    @Override
    public void guardar(PartnerLocation partnerLocation) {
        PartnerLocationEntity entity = partnerLocationMapper.aEntity(partnerLocation, null);
        PartnerLocationEntity saved = partnerLocationJpaRepository.save(entity);
        partnerLocation.setPartnerLocationId(saved.getPartnerLocationId());
    }

    @Override
    public Optional<PartnerLocation> buscarPorId(Long partnerLocationId) {
        return partnerLocationJpaRepository.findById(partnerLocationId)
            .map(partnerLocationMapper::aDominio);
    }

    @Override
    public void actualizar(PartnerLocation partnerLocation) {
        PartnerLocationEntity existing = partnerLocationJpaRepository.findById(partnerLocation.getPartnerLocationId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la ubicacion del partner con id: " + partnerLocation.getPartnerLocationId()));
        partnerLocationMapper.aEntity(partnerLocation, existing);
        partnerLocationJpaRepository.save(existing);
    }

    @Override
    public List<PartnerLocation> buscarPorPartnerId(Long partnerId) {
        return partnerLocationJpaRepository.findByPartnerId(partnerId)
            .stream()
            .map(partnerLocationMapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long partnerLocationId) {
        partnerLocationJpaRepository.deleteById(partnerLocationId);
    }
}
