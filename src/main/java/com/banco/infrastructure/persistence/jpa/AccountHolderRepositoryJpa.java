package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.AccountHolderRepository;
import com.banco.domain.model.entities.AccountHolder;
import com.banco.infrastructure.persistence.entities.AccountHolderEntity;
import com.banco.infrastructure.persistence.jpa.Interface.AccountHolderJpaRepository;
import com.banco.infrastructure.persistence.mappers.AccountHolderMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class AccountHolderRepositoryJpa implements AccountHolderRepository {

    private final AccountHolderJpaRepository jpaRepository;
    private final AccountHolderMapper mapper;

    public AccountHolderRepositoryJpa(AccountHolderJpaRepository jpaRepository, AccountHolderMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }


    @Override
    public void guardar(AccountHolder accountHolder) {
        AccountHolderEntity entity = mapper.aEntity(accountHolder, null);
        AccountHolderEntity saved = jpaRepository.save(entity);
        accountHolder.setHolderId(saved.getHolderId());
    }

    @Override
    public Optional<AccountHolder> buscarPorId(UUID holderId) {
        return jpaRepository.findById(holderId).map(mapper::aDominio);
    }

    @Override
    public List<AccountHolder> buscarPorAccountId(UUID accountId) {
        return jpaRepository.findByAccountId(accountId).stream()
            .map(mapper::aDominio).collect(Collectors.toList());
    }

    @Override
    public List<AccountHolder> buscarPorCustomerId(UUID customerId) {
        return jpaRepository.findByCustomerId(customerId).stream()
            .map(mapper::aDominio).collect(Collectors.toList());
    }

    @Override
    public void actualizar(AccountHolder accountHolder) {
        AccountHolderEntity existing = jpaRepository.findById(accountHolder.getHolderId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el titular con id: " + accountHolder.getHolderId()));
        mapper.aEntity(accountHolder, existing);
        jpaRepository.save(existing);
    }

    @Override
    public void eliminar(UUID holderId) {
        jpaRepository.deleteById(holderId);
    }
}
