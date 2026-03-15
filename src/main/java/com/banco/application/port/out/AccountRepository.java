package com.banco.application.port.out;

import com.banco.domain.model.entities.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {

    void guardar(Account account);

    Optional<Account> buscarPorId(UUID accountId);

    Optional<Account> buscarPorNumero(String accountNumber);

    List<Account> buscarPorCustomerId(UUID customerId);

    void actualizar(Account account);

    void eliminar(UUID accountId);
}
