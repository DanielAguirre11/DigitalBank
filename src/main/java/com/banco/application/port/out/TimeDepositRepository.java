package com.banco.application.port.out;

import com.banco.domain.model.entities.TimeDeposit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TimeDepositRepository {
    void guardar(TimeDeposit timeDeposit);
    Optional<TimeDeposit> buscarPorId(UUID depositId);
    List<TimeDeposit> buscarPorAccountId(UUID accountId);
}
