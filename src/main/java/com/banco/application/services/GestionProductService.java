package com.banco.application.services;

import com.banco.application.dto.ActualizarProductRequest;
import com.banco.application.dto.ProductRequest;
import com.banco.application.dto.ProductResponse;
import com.banco.application.port.out.ProductRepository;
import com.banco.domain.model.entities.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionProductService {

    private final ProductRepository repository;

    public GestionProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse crearProduct(ProductRequest request) {
        if (repository.existePorCodigo(request.getCode())) {
            throw new IllegalArgumentException(
                "Ya existe un producto con el codigo: " + request.getCode());
        }

        Product product = new Product(
            request.getFamilyId(),
            request.getCode(),
            request.getName(),
            request.getDescription(),
            request.getProductType(),
            request.getCurrencyId(),
            request.getBaseInterestRate(),
            request.getMaxInterestRate(),
            request.getMinInterestRate(),
            request.getMinTermDays(),
            request.getMaxTermDays(),
            request.getMinAmount(),
            request.getMaxAmount(),
            request.isRequiresCollateral(),
            request.isTaxApplicable(),
            request.getStatus(),
            request.getEffectiveDate(),
            request.getExpiryDate()
        );

        repository.guardar(product);
        return toResponse(product);
    }

    @Transactional(readOnly = true)
    public ProductResponse buscarPorId(Integer productId) {
        return repository.buscarPorId(productId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el producto con id: " + productId));
    }

    @Transactional(readOnly = true)
    public ProductResponse buscarPorCodigo(String code) {
        return repository.buscarPorCodigo(code)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el producto con codigo: " + code));
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> buscarPorFamilyId(Short familyId) {
        return repository.buscarPorFamilyId(familyId).stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> buscarTodos() {
        return repository.buscarTodos().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public ProductResponse actualizarProduct(Integer productId, ActualizarProductRequest request) {
        Product product = repository.buscarPorId(productId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el producto con id: " + productId));

        request.getName().ifPresent(product::setName);
        request.getDescription().ifPresent(product::setDescription);
        request.getBaseInterestRate().ifPresent(product::setBaseInterestRate);
        request.getMaxInterestRate().ifPresent(product::setMaxInterestRate);
        request.getMinInterestRate().ifPresent(product::setMinInterestRate);
        request.getMinTermDays().ifPresent(product::setMinTermDays);
        request.getMaxTermDays().ifPresent(product::setMaxTermDays);
        request.getMinAmount().ifPresent(product::setMinAmount);
        request.getMaxAmount().ifPresent(product::setMaxAmount);
        request.getRequiresCollateral().ifPresent(product::setRequiresCollateral);
        request.getTaxApplicable().ifPresent(product::setTaxApplicable);
        request.getStatus().ifPresent(product::setStatus);
        request.getExpiryDate().ifPresent(product::setExpiryDate);

        repository.actualizar(product);
        return toResponse(product);
    }

    public void eliminarProduct(Integer productId) {
        repository.buscarPorId(productId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el producto con id: " + productId));
        repository.eliminar(productId);
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(
            p.getProductId(),
            p.getFamilyId(),
            p.getCode(),
            p.getName(),
            p.getDescription(),
            p.getProductType(),
            p.getCurrencyId(),
            p.getBaseInterestRate(),
            p.getMaxInterestRate(),
            p.getMinInterestRate(),
            p.getMinTermDays(),
            p.getMaxTermDays(),
            p.getMinAmount(),
            p.getMaxAmount(),
            p.isRequiresCollateral(),
            p.isTaxApplicable(),
            p.getStatus(),
            p.getEffectiveDate(),
            p.getExpiryDate(),
            p.getCreatedAt()
        );
    }
}
