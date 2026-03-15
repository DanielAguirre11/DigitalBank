package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.TransactionRepository;
import com.banco.domain.model.entities.Transaction;
import com.banco.infrastructure.persistence.entities.TransactionEntity;
import com.banco.infrastructure.persistence.jpa.Interface.TransactionJpaRepository;
import com.banco.infrastructure.persistence.mappers.TransactionMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class TransactionRepositoryJpa implements TransactionRepository {

    private final TransactionJpaRepository jpaRepository;
    private final TransactionMapper mapper;

    public TransactionRepositoryJpa(TransactionJpaRepository jpaRepository, TransactionMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }


    @Override
    public void guardar(Transaction transaction) {
        TransactionEntity entity = mapper.aEntity(transaction, null);
        TransactionEntity saved = jpaRepository.save(entity);
        transaction.setTransactionId(saved.getTransactionId());
    }

    @Override
    public Optional<Transaction> buscarPorId(UUID transactionId) {
        return jpaRepository.findById(transactionId).map(mapper::aDominio);
    }

    @Override
    public List<Transaction> buscarPorAccountId(UUID accountId) {
        return jpaRepository.findByAccountIdOrderByTransactionDateDesc(accountId)
            .stream().map(mapper::aDominio).collect(Collectors.toList());
    }

    @Override
    public void actualizar(Transaction transaction) {
        TransactionEntity existing = jpaRepository.findById(transaction.getTransactionId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la transaccion con id: " + transaction.getTransactionId()));
        mapper.aEntity(transaction, existing);
        jpaRepository.save(existing);
    }
}
