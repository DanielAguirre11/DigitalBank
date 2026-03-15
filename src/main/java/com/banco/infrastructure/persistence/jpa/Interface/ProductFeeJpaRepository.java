package com.banco.infrastructure.persistence.jpa.Interface;

import com.banco.infrastructure.persistence.entities.ProductFeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductFeeJpaRepository extends JpaRepository<ProductFeeEntity, Integer> {

    List<ProductFeeEntity> findByProductId(Integer productId);
}
