package com.banco.application.port.out;

import com.banco.domain.model.entities.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {

    void guardar(Transaction transaction);

    Optional<Transaction> buscarPorId(UUID transactionId);

    List<Transaction> buscarPorAccountId(UUID accountId);

    void actualizar(Transaction transaction);
}
