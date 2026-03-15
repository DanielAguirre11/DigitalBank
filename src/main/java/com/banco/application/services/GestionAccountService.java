package com.banco.application.services;

import com.banco.application.dto.AccountRequest;
import com.banco.application.dto.AccountResponse;
import com.banco.application.dto.ActualizarAccountRequest;
import com.banco.application.port.out.AccountRepository;
import com.banco.domain.model.entities.Account;
import com.banco.domain.model.valueobjects.AccountStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionAccountService {

    private final AccountRepository repository;

    public GestionAccountService(AccountRepository repository) {
        this.repository = repository;
    }


    public AccountResponse crearAccount(AccountRequest request) {
        if (repository.buscarPorNumero(request.getAccountNumber()).isPresent()) {
            throw new IllegalArgumentException(
                "Ya existe una cuenta con el numero: " + request.getAccountNumber());
        }

        Account account = new Account(
            request.getAccountNumber(),
            request.getProductId(),
            request.getCustomerId(),
            request.getCurrencyId(),
            request.getStatus() != null ? request.getStatus() : AccountStatus.ACTIVE,
            request.getOpenDate() != null ? request.getOpenDate() : LocalDate.now(),
            request.getBranchId(),
            request.getAccountOfficerId(),
            request.isOverdraftAllowed(),
            request.getOverdraftLimit()
        );

        repository.guardar(account);
        return toResponse(account);
    }

    @Transactional(readOnly = true)
    public AccountResponse buscarPorId(UUID accountId) {
        return repository.buscarPorId(accountId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con id: " + accountId));
    }

    @Transactional(readOnly = true)
    public AccountResponse buscarPorNumero(String accountNumber) {
        return repository.buscarPorNumero(accountNumber)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con numero: " + accountNumber));
    }

    @Transactional(readOnly = true)
    public List<AccountResponse> buscarPorCustomerId(UUID customerId) {
        return repository.buscarPorCustomerId(customerId).stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public AccountResponse actualizarAccount(UUID accountId, ActualizarAccountRequest request) {
        Account account = repository.buscarPorId(accountId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con id: " + accountId));

        request.getStatus().ifPresent(account::setStatus);
        request.getCloseDate().ifPresent(account::setCloseDate);
        request.getBranchId().ifPresent(account::setBranchId);
        request.getAccountOfficerId().ifPresent(account::setAccountOfficerId);
        request.getOverdraftAllowed().ifPresent(account::setOverdraftAllowed);
        request.getOverdraftLimit().ifPresent(account::setOverdraftLimit);

        repository.actualizar(account);
        return toResponse(account);
    }

    public void eliminarAccount(UUID accountId) {
        repository.buscarPorId(accountId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con id: " + accountId));
        repository.eliminar(accountId);
    }


    private AccountResponse toResponse(Account a) {
        return new AccountResponse(
            a.getAccountId(),
            a.getAccountNumber(),
            a.getProductId(),
            a.getCustomerId(),
            a.getCurrencyId(),
            a.getAvailableBalance(),
            a.getLedgerBalance(),
            a.getHeldBalance(),
            a.getStatus(),
            a.getOpenDate(),
            a.getCloseDate(),
            a.getBranchId(),
            a.getAccountOfficerId(),
            a.isOverdraftAllowed(),
            a.getOverdraftLimit(),
            a.getCreatedAt(),
            a.getUpdatedAt()
        );
    }
}
