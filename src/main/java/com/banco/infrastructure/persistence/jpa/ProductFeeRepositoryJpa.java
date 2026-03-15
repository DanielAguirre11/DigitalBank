package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.ProductFeeRepository;
import com.banco.domain.model.entities.ProductFee;
import com.banco.infrastructure.persistence.entities.ProductFeeEntity;
import com.banco.infrastructure.persistence.jpa.Interface.ProductFeeJpaRepository;
import com.banco.infrastructure.persistence.mappers.ProductFeeMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProductFeeRepositoryJpa implements ProductFeeRepository {

    private final ProductFeeJpaRepository jpaRepository;
    private final ProductFeeMapper mapper;

    public ProductFeeRepositoryJpa(ProductFeeJpaRepository jpaRepository, ProductFeeMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void guardar(ProductFee productFee) {
        ProductFeeEntity entity = mapper.aEntity(productFee, null);
        ProductFeeEntity saved = jpaRepository.save(entity);
        productFee.setFeeId(saved.getFeeId());
    }

    @Override
    public Optional<ProductFee> buscarPorId(Integer feeId) {
        return jpaRepository.findById(feeId).map(mapper::aDominio);
    }

    @Override
    public List<ProductFee> buscarPorProductId(Integer productId) {
        return jpaRepository.findByProductId(productId).stream()
            .map(mapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public void actualizar(ProductFee productFee) {
        ProductFeeEntity existing = jpaRepository.findById(productFee.getFeeId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el cargo de producto con id: " + productFee.getFeeId()));
        mapper.aEntity(productFee, existing);
        jpaRepository.save(existing);
    }

    @Override
    public void eliminar(Integer feeId) {
        jpaRepository.deleteById(feeId);
    }
}
