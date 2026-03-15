package com.banco.application.port.out;

import com.banco.domain.model.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void guardar(Product product);
    Optional<Product> buscarPorId(Integer productId);
    Optional<Product> buscarPorCodigo(String code);
    List<Product> buscarPorFamilyId(Short familyId);
    List<Product> buscarTodos();
    void actualizar(Product product);
    void eliminar(Integer productId);
    boolean existePorCodigo(String code);
    boolean existePorCodigoExcluyendo(String code, Integer productId);
}
