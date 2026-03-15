package com.banco.infrastructure.persistence.jpa;

import com.banco.application.port.out.TimeDepositRepository;
import com.banco.domain.model.entities.TimeDeposit;
import com.banco.infrastructure.persistence.entities.TimeDepositEntity;
import com.banco.infrastructure.persistence.jpa.Interface.TimeDepositJpaRepository;
import com.banco.infrastructure.persistence.mappers.TimeDepositMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class TimeDepositRepositoryJpa implements TimeDepositRepository {

    private final TimeDepositJpaRepository jpaRepository;
    private final TimeDepositMapper mapper;

    public TimeDepositRepositoryJpa(TimeDepositJpaRepository jpaRepository, TimeDepositMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }


    @Override
    public void guardar(TimeDeposit timeDeposit) {
        TimeDepositEntity entity = mapper.aEntity(timeDeposit, null);
        TimeDepositEntity saved = jpaRepository.save(entity);
        timeDeposit.setDepositId(saved.getDepositId());
    }

    @Override
    public Optional<TimeDeposit> buscarPorId(UUID depositId) {
        return jpaRepository.findById(depositId).map(mapper::aDominio);
    }

    @Override
    public List<TimeDeposit> buscarPorAccountId(UUID accountId) {
        return jpaRepository.findByAccountId(accountId).stream()
            .map(mapper::aDominio).collect(Collectors.toList());
    }
}
