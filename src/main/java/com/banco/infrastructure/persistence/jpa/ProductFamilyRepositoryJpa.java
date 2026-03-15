package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.ProductFamilyRepository;
import com.banco.domain.model.entities.ProductFamily;
import com.banco.infrastructure.persistence.entities.ProductFamilyEntity;
import com.banco.infrastructure.persistence.jpa.Interface.ProductFamilyJpaRepository;
import com.banco.infrastructure.persistence.mappers.ProductFamilyMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProductFamilyRepositoryJpa implements ProductFamilyRepository {

    private final ProductFamilyJpaRepository jpaRepository;
    private final ProductFamilyMapper mapper;

    public ProductFamilyRepositoryJpa(ProductFamilyJpaRepository jpaRepository, ProductFamilyMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void guardar(ProductFamily productFamily) {
        ProductFamilyEntity entity = mapper.aEntity(productFamily, null);
        ProductFamilyEntity saved = jpaRepository.save(entity);
        productFamily.setFamilyId(saved.getFamilyId());
    }

    @Override
    public Optional<ProductFamily> buscarPorId(Short familyId) {
        return jpaRepository.findById(familyId).map(mapper::aDominio);
    }

    @Override
    public Optional<ProductFamily> buscarPorCodigo(String code) {
        return jpaRepository.findByCode(code).map(mapper::aDominio);
    }

    @Override
    public List<ProductFamily> buscarTodos() {
        return jpaRepository.findAll().stream()
            .map(mapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public void actualizar(ProductFamily productFamily) {
        ProductFamilyEntity existing = jpaRepository.findById(productFamily.getFamilyId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la familia de productos con id: " + productFamily.getFamilyId()));
        mapper.aEntity(productFamily, existing);
        jpaRepository.save(existing);
    }

    @Override
    public void eliminar(Short familyId) {
        jpaRepository.deleteById(familyId);
    }

    @Override
    public boolean existePorCodigo(String code) {
        return jpaRepository.existsByCode(code);
    }

    @Override
    public boolean existePorCodigoExcluyendo(String code, Short familyId) {
        return jpaRepository.existsByCodeAndFamilyIdNot(code, familyId);
    }
}
