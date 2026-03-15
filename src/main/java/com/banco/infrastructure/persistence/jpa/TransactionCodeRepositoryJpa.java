package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.TransactionCodeRepository;
import com.banco.domain.model.entities.TransactionCode;
import com.banco.infrastructure.persistence.entities.TransactionCodeEntity;
import com.banco.infrastructure.persistence.jpa.Interface.TransactionCodeJpaRepository;
import com.banco.infrastructure.persistence.mappers.TransactionCodeMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class TransactionCodeRepositoryJpa implements TransactionCodeRepository {

    private final TransactionCodeJpaRepository jpaRepository;
    private final TransactionCodeMapper mapper;

    public TransactionCodeRepositoryJpa(TransactionCodeJpaRepository jpaRepository,
                                        TransactionCodeMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }


    @Override
    public void guardar(TransactionCode transactionCode) {
        TransactionCodeEntity entity = mapper.aEntity(transactionCode, null);
        TransactionCodeEntity saved = jpaRepository.save(entity);
        transactionCode.setTransactionCodeId(saved.getTransactionCodeId());
    }

    @Override
    public Optional<TransactionCode> buscarPorId(Short transactionCodeId) {
        return jpaRepository.findById(transactionCodeId).map(mapper::aDominio);
    }

    @Override
    public Optional<TransactionCode> buscarPorCodigo(String code) {
        return jpaRepository.findByCode(code).map(mapper::aDominio);
    }

    @Override
    public void actualizar(TransactionCode transactionCode) {
        TransactionCodeEntity existing = jpaRepository.findById(transactionCode.getTransactionCodeId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el codigo de transaccion con id: " + transactionCode.getTransactionCodeId()));
        mapper.aEntity(transactionCode, existing);
        jpaRepository.save(existing);
    }

    @Override
    public List<TransactionCode> buscarTodos() {
        return jpaRepository.findAll().stream().map(mapper::aDominio).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Short transactionCodeId) {
        jpaRepository.deleteById(transactionCodeId);
    }

    @Override
    public boolean existePorCodigo(String code) {
        return jpaRepository.existsByCode(code);
    }

    @Override
    public boolean existePorCodigoExcluyendo(String code, Short transactionCodeId) {
        return jpaRepository.existsByCodeAndTransactionCodeIdNot(code, transactionCodeId);
    }
}
