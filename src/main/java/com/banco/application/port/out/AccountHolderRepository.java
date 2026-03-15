package com.banco.application.port.out;

import com.banco.domain.model.entities.AccountHolder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountHolderRepository {
    void guardar(AccountHolder accountHolder);
    Optional<AccountHolder> buscarPorId(UUID holderId);
    List<AccountHolder> buscarPorAccountId(UUID accountId);
    List<AccountHolder> buscarPorCustomerId(UUID customerId);
    void actualizar(AccountHolder accountHolder);
    void eliminar(UUID holderId);
}
