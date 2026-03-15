package com.banco.application.services;

import com.banco.application.dto.AccountHolderRequest;
import com.banco.application.dto.AccountHolderResponse;
import com.banco.application.dto.ActualizarAccountHolderRequest;
import com.banco.application.port.out.AccountHolderRepository;
import com.banco.domain.model.entities.AccountHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionAccountHolderService {

    private final AccountHolderRepository repository;

    public GestionAccountHolderService(AccountHolderRepository repository) {
        this.repository = repository;
    }


    public AccountHolderResponse crearAccountHolder(AccountHolderRequest request) {
        AccountHolder accountHolder = new AccountHolder(
            request.getAccountId(),
            request.getCustomerId(),
            request.getHolderType(),
            request.getOwnershipPercentage() != null ? request.getOwnershipPercentage() : new BigDecimal("100"),
            request.getStartDate() != null ? request.getStartDate() : LocalDate.now(),
            request.getEndDate(),
            request.isActive()
        );

        repository.guardar(accountHolder);
        return toResponse(accountHolder);
    }

    @Transactional(readOnly = true)
    public AccountHolderResponse buscarPorId(UUID holderId) {
        return repository.buscarPorId(holderId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el titular con id: " + holderId));
    }

    @Transactional(readOnly = true)
    public List<AccountHolderResponse> buscarPorAccountId(UUID accountId) {
        return repository.buscarPorAccountId(accountId).stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AccountHolderResponse> buscarPorCustomerId(UUID customerId) {
        return repository.buscarPorCustomerId(customerId).stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public AccountHolderResponse actualizarAccountHolder(UUID holderId, ActualizarAccountHolderRequest request) {
        AccountHolder accountHolder = repository.buscarPorId(holderId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el titular con id: " + holderId));

        request.getHolderType().ifPresent(accountHolder::setHolderType);
        request.getOwnershipPercentage().ifPresent(accountHolder::setOwnershipPercentage);
        request.getStartDate().ifPresent(accountHolder::setStartDate);
        request.getEndDate().ifPresent(accountHolder::setEndDate);
        request.getActive().ifPresent(accountHolder::setActive);

        repository.actualizar(accountHolder);
        return toResponse(accountHolder);
    }

    public void eliminarAccountHolder(UUID holderId) {
        repository.buscarPorId(holderId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el titular con id: " + holderId));
        repository.eliminar(holderId);
    }


    private AccountHolderResponse toResponse(AccountHolder a) {
        return new AccountHolderResponse(
            a.getHolderId(),
            a.getAccountId(),
            a.getCustomerId(),
            a.getHolderType(),
            a.getOwnershipPercentage(),
            a.getStartDate(),
            a.getEndDate(),
            a.isActive()
        );
    }
}
