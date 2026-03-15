package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.AccountRepository;
import com.banco.domain.model.entities.Account;
import com.banco.infrastructure.persistence.entities.AccountEntity;
import com.banco.infrastructure.persistence.jpa.Interface.AccountJpaRepository;
import com.banco.infrastructure.persistence.mappers.AccountMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class AccountRepositoryJpa implements AccountRepository {

    private final AccountJpaRepository jpaRepository;
    private final AccountMapper mapper;

    public AccountRepositoryJpa(AccountJpaRepository jpaRepository, AccountMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }


    @Override
    public void guardar(Account account) {
        AccountEntity entity = mapper.aEntity(account, null);
        AccountEntity saved = jpaRepository.save(entity);
        account.setAccountId(saved.getAccountId());
    }

    @Override
    public Optional<Account> buscarPorId(UUID accountId) {
        return jpaRepository.findById(accountId).map(mapper::aDominio);
    }

    @Override
    public Optional<Account> buscarPorNumero(String accountNumber) {
        return jpaRepository.findByAccountNumber(accountNumber).map(mapper::aDominio);
    }

    @Override
    public List<Account> buscarPorCustomerId(UUID customerId) {
        return jpaRepository.findByCustomerId(customerId).stream()
            .map(mapper::aDominio).collect(Collectors.toList());
    }

    @Override
    public void actualizar(Account account) {
        AccountEntity existing = jpaRepository.findById(account.getAccountId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con id: " + account.getAccountId()));
        mapper.aEntity(account, existing);
        jpaRepository.save(existing);
    }

    @Override
    public void eliminar(UUID accountId) {
        jpaRepository.deleteById(accountId);
    }
}
