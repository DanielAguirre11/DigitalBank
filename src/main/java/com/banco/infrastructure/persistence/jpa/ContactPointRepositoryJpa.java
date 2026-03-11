package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.ContactPointRepository;
import com.banco.domain.model.entities.ContactPoint;
import com.banco.infrastructure.persistence.entities.ContactPointEntity;
import com.banco.infrastructure.persistence.jpa.Interface.ContactPointJpaRepository;
import com.banco.infrastructure.persistence.mappers.ContactPointMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ContactPointRepositoryJpa implements ContactPointRepository {

    private final ContactPointJpaRepository contactPointJpaRepository;
    private final ContactPointMapper contactPointMapper;

    public ContactPointRepositoryJpa(ContactPointJpaRepository contactPointJpaRepository,
                                     ContactPointMapper contactPointMapper) {
        this.contactPointJpaRepository = contactPointJpaRepository;
        this.contactPointMapper = contactPointMapper;
    }


    @Override
    public void guardar(ContactPoint contactPoint) {
        ContactPointEntity entity = contactPointMapper.aEntity(contactPoint, null);
        ContactPointEntity saved = contactPointJpaRepository.save(entity);
        contactPoint.setContactPointId(saved.getContactPointId());
    }

    @Override
    public Optional<ContactPoint> buscarPorId(Long contactPointId) {
        return contactPointJpaRepository.findById(contactPointId)
            .map(contactPointMapper::aDominio);
    }

    @Override
    public void actualizar(ContactPoint contactPoint) {
        ContactPointEntity existing = contactPointJpaRepository.findById(contactPoint.getContactPointId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el punto de contacto con id: " + contactPoint.getContactPointId()));
        contactPointMapper.aEntity(contactPoint, existing);
        contactPointJpaRepository.save(existing);
    }

    @Override
    public List<ContactPoint> buscarPorPartyId(Integer partyId) {
        return contactPointJpaRepository.findByPartyId(partyId)
            .stream()
            .map(contactPointMapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long contactPointId) {
        contactPointJpaRepository.deleteById(contactPointId);
    }
}
