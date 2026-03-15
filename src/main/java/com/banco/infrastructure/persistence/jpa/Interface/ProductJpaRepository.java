package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {

    Optional<ProductEntity> findByCode(String code);

    List<ProductEntity> findByFamilyId(Short familyId);

    boolean existsByCode(String code);

    boolean existsByCodeAndProductIdNot(String code, Integer productId);
}
