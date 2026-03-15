package com.banco.application.services;

import com.banco.application.dto.ActualizarProductFeeRequest;
import com.banco.application.dto.ProductFeeRequest;
import com.banco.application.dto.ProductFeeResponse;
import com.banco.application.port.out.ProductFeeRepository;
import com.banco.domain.model.entities.ProductFee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionProductFeeService {

    private final ProductFeeRepository repository;

    public GestionProductFeeService(ProductFeeRepository repository) {
        this.repository = repository;
    }

    public ProductFeeResponse crearProductFee(ProductFeeRequest request) {
        ProductFee productFee = new ProductFee(
            request.getProductId(),
            request.getFeeType(),
            request.getCalculationMode(),
            request.getValue(),
            request.getCurrencyId(),
            request.getFrequency(),
            request.isVatApplicable(),
            request.isActive()
        );

        repository.guardar(productFee);
        return toResponse(productFee);
    }

    @Transactional(readOnly = true)
    public ProductFeeResponse buscarPorId(Integer feeId) {
        return repository.buscarPorId(feeId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el cargo de producto con id: " + feeId));
    }

    @Transactional(readOnly = true)
    public List<ProductFeeResponse> buscarPorProductId(Integer productId) {
        return repository.buscarPorProductId(productId).stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public ProductFeeResponse actualizarProductFee(Integer feeId, ActualizarProductFeeRequest request) {
        ProductFee productFee = repository.buscarPorId(feeId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el cargo de producto con id: " + feeId));

        request.getFeeType().ifPresent(productFee::setFeeType);
        request.getCalculationMode().ifPresent(productFee::setCalculationMode);
        request.getValue().ifPresent(productFee::setValue);
        request.getCurrencyId().ifPresent(productFee::setCurrencyId);
        request.getFrequency().ifPresent(productFee::setFrequency);
        request.getVatApplicable().ifPresent(productFee::setVatApplicable);
        request.getActive().ifPresent(productFee::setActive);

        repository.actualizar(productFee);
        return toResponse(productFee);
    }

    public void eliminarProductFee(Integer feeId) {
        repository.buscarPorId(feeId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el cargo de producto con id: " + feeId));
        repository.eliminar(feeId);
    }

    private ProductFeeResponse toResponse(ProductFee pf) {
        return new ProductFeeResponse(
            pf.getFeeId(),
            pf.getProductId(),
            pf.getFeeType(),
            pf.getCalculationMode(),
            pf.getValue(),
            pf.getCurrencyId(),
            pf.getFrequency(),
            pf.isVatApplicable(),
            pf.isActive()
        );
    }
}
