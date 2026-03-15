package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.ProductRepository;
import com.banco.domain.model.entities.Product;
import com.banco.infrastructure.persistence.entities.ProductEntity;
import com.banco.infrastructure.persistence.jpa.Interface.ProductJpaRepository;
import com.banco.infrastructure.persistence.mappers.ProductMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProductRepositoryJpa implements ProductRepository {

    private final ProductJpaRepository jpaRepository;
    private final ProductMapper mapper;

    public ProductRepositoryJpa(ProductJpaRepository jpaRepository, ProductMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void guardar(Product product) {
        ProductEntity entity = mapper.aEntity(product, null);
        ProductEntity saved = jpaRepository.save(entity);
        product.setProductId(saved.getProductId());
    }

    @Override
    public Optional<Product> buscarPorId(Integer productId) {
        return jpaRepository.findById(productId).map(mapper::aDominio);
    }

    @Override
    public Optional<Product> buscarPorCodigo(String code) {
        return jpaRepository.findByCode(code).map(mapper::aDominio);
    }

    @Override
    public List<Product> buscarPorFamilyId(Short familyId) {
        return jpaRepository.findByFamilyId(familyId).stream()
            .map(mapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public List<Product> buscarTodos() {
        return jpaRepository.findAll().stream()
            .map(mapper::aDominio)
            .collect(Collectors.toList());
    }

    @Override
    public void actualizar(Product product) {
        ProductEntity existing = jpaRepository.findById(product.getProductId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el producto con id: " + product.getProductId()));
        mapper.aEntity(product, existing);
        jpaRepository.save(existing);
    }

    @Override
    public void eliminar(Integer productId) {
        jpaRepository.deleteById(productId);
    }

    @Override
    public boolean existePorCodigo(String code) {
        return jpaRepository.existsByCode(code);
    }

    @Override
    public boolean existePorCodigoExcluyendo(String code, Integer productId) {
        return jpaRepository.existsByCodeAndProductIdNot(code, productId);
    }
}
