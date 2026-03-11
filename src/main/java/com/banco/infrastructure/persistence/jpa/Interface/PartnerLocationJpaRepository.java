package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.PartnerLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerLocationJpaRepository extends JpaRepository<PartnerLocationEntity, Long> {

    List<PartnerLocationEntity> findByPartnerId(Long partnerId);
}
