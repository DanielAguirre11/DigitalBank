package com.banco.application.port.out;

import com.banco.domain.model.entities.ProductFee;

import java.util.List;
import java.util.Optional;

public interface ProductFeeRepository {
    void guardar(ProductFee productFee);
    Optional<ProductFee> buscarPorId(Integer feeId);
    List<ProductFee> buscarPorProductId(Integer productId);
    void actualizar(ProductFee productFee);
    void eliminar(Integer feeId);
}
