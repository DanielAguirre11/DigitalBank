package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.ProductFamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFamilyJpaRepository extends JpaRepository<ProductFamilyEntity, Short> {

    Optional<ProductFamilyEntity> findByCode(String code);

    boolean existsByCode(String code);

    boolean existsByCodeAndFamilyIdNot(String code, Short familyId);
}
