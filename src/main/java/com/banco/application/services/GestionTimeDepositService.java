package com.banco.application.services;

import com.banco.application.dto.TimeDepositRequest;
import com.banco.application.dto.TimeDepositResponse;
import com.banco.application.port.out.TimeDepositRepository;
import com.banco.domain.model.entities.TimeDeposit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionTimeDepositService {

    private final TimeDepositRepository repository;

    public GestionTimeDepositService(TimeDepositRepository repository) {
        this.repository = repository;
    }


    public TimeDepositResponse crearTimeDeposit(TimeDepositRequest request) {
        if (!request.getMaturityDate().isAfter(request.getStartDate())) {
            throw new IllegalArgumentException(
                "La fecha de vencimiento debe ser posterior a la fecha de inicio");
        }

        TimeDeposit timeDeposit = new TimeDeposit(
            request.getAccountId(),
            request.getOriginalAmount(),
            request.getAgreedRate(),
            request.getStartDate(),
            request.getMaturityDate(),
            request.getTermDays(),
            request.getRenewalMode(),
            request.isCapitalizeInterest()
        );

        repository.guardar(timeDeposit);
        return toResponse(timeDeposit);
    }

    @Transactional(readOnly = true)
    public TimeDepositResponse buscarPorId(UUID depositId) {
        return repository.buscarPorId(depositId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el deposito con id: " + depositId));
    }

    @Transactional(readOnly = true)
    public List<TimeDepositResponse> buscarPorAccountId(UUID accountId) {
        return repository.buscarPorAccountId(accountId).stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }


    private TimeDepositResponse toResponse(TimeDeposit d) {
        return new TimeDepositResponse(
            d.getDepositId(),
            d.getAccountId(),
            d.getOriginalAmount(),
            d.getAgreedRate(),
            d.getStartDate(),
            d.getMaturityDate(),
            d.getTermDays(),
            d.getRenewalMode(),
            d.isCapitalizeInterest(),
            d.getStatus(),
            d.getAccruedInterest()
        );
    }
}
