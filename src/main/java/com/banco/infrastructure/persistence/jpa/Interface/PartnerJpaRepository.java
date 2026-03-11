package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.domain.model.valueobjects.PartnerIdentificationType;
import com.banco.infrastructure.persistence.entities.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerJpaRepository extends JpaRepository<PartnerEntity, Long> {

    boolean existsByIdentificationTypeAndIdentificationValue(
        PartnerIdentificationType identificationType, String identificationValue);

    boolean existsByIdentificationTypeAndIdentificationValueAndPartnerIdNot(
        PartnerIdentificationType identificationType, String identificationValue, Long partnerId);
}
