package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.ContactPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactPointJpaRepository extends JpaRepository<ContactPointEntity, Long> {

    List<ContactPointEntity> findByPartyId(Integer partyId);
}
