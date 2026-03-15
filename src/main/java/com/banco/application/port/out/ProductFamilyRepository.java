package com.banco.application.port.out;

import com.banco.domain.model.entities.ProductFamily;

import java.util.List;
import java.util.Optional;

public interface ProductFamilyRepository {
    void guardar(ProductFamily productFamily);
    Optional<ProductFamily> buscarPorId(Short familyId);
    Optional<ProductFamily> buscarPorCodigo(String code);
    List<ProductFamily> buscarTodos();
    void actualizar(ProductFamily productFamily);
    void eliminar(Short familyId);
    boolean existePorCodigo(String code);
    boolean existePorCodigoExcluyendo(String code, Short familyId);
}
