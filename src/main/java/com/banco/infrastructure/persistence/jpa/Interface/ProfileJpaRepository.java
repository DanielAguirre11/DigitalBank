package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileJpaRepository extends JpaRepository<ProfileEntity, Long> {

    List<ProfileEntity> findByPartnerId(Long partnerId);
}
