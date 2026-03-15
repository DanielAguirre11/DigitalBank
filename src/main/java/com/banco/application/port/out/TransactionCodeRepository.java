package com.banco.application.port.out;

import com.banco.domain.model.entities.TransactionCode;

import java.util.List;
import java.util.Optional;

public interface TransactionCodeRepository {

    void guardar(TransactionCode transactionCode);

    Optional<TransactionCode> buscarPorId(Short transactionCodeId);

    Optional<TransactionCode> buscarPorCodigo(String code);

    void actualizar(TransactionCode transactionCode);

    List<TransactionCode> buscarTodos();

    void eliminar(Short transactionCodeId);

    boolean existePorCodigo(String code);

    boolean existePorCodigoExcluyendo(String code, Short transactionCodeId);
}
