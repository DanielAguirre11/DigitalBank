package com.banco.application.services;

import com.banco.application.dto.ActualizarProductFamilyRequest;
import com.banco.application.dto.ProductFamilyRequest;
import com.banco.application.dto.ProductFamilyResponse;
import com.banco.application.port.out.ProductFamilyRepository;
import com.banco.domain.model.entities.ProductFamily;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionProductFamilyService {

    private final ProductFamilyRepository repository;

    public GestionProductFamilyService(ProductFamilyRepository repository) {
        this.repository = repository;
    }

    public ProductFamilyResponse crearProductFamily(ProductFamilyRequest request) {
        if (repository.existePorCodigo(request.getCode())) {
            throw new IllegalArgumentException(
                "Ya existe una familia de productos con el codigo: " + request.getCode());
        }

        ProductFamily productFamily = new ProductFamily(
            request.getCode(),
            request.getName(),
            request.getDescription(),
            request.isActive()
        );

        repository.guardar(productFamily);
        return toResponse(productFamily);
    }

    @Transactional(readOnly = true)
    public ProductFamilyResponse buscarPorId(Short familyId) {
        return repository.buscarPorId(familyId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la familia de productos con id: " + familyId));
    }

    @Transactional(readOnly = true)
    public List<ProductFamilyResponse> buscarTodos() {
        return repository.buscarTodos().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public ProductFamilyResponse actualizarProductFamily(Short familyId, ActualizarProductFamilyRequest request) {
        ProductFamily productFamily = repository.buscarPorId(familyId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la familia de productos con id: " + familyId));

        request.getCode().ifPresent(code -> {
            if (repository.existePorCodigoExcluyendo(code, familyId)) {
                throw new IllegalArgumentException(
                    "Ya existe una familia de productos con el codigo: " + code);
            }
            productFamily.setCode(code);
        });
        request.getName().ifPresent(productFamily::setName);
        request.getDescription().ifPresent(productFamily::setDescription);
        request.getActive().ifPresent(productFamily::setActive);

        repository.actualizar(productFamily);
        return toResponse(productFamily);
    }

    public void eliminarProductFamily(Short familyId) {
        repository.buscarPorId(familyId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la familia de productos con id: " + familyId));
        repository.eliminar(familyId);
    }

    private ProductFamilyResponse toResponse(ProductFamily pf) {
        return new ProductFamilyResponse(
            pf.getFamilyId(),
            pf.getCode(),
            pf.getName(),
            pf.getDescription(),
            pf.isActive()
        );
    }
}
