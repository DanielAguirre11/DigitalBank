package com.banco.infrastructure.persistence.jpa;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.banco.application.port.out.ClienteRepository;
import com.banco.domain.model.entities.Cliente;
import com.banco.infrastructure.persistence.entities.ClienteEntity;
import com.banco.infrastructure.persistence.jpa.Interface.ClienteJpaRepository;
import com.banco.infrastructure.persistence.mappers.ClienteMapper;






@Repository
@Transactional
public class ClienteRepositoryJpa implements ClienteRepository {
    

    
    //INYECCION DE DEPENDENCIA
    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper clienteMapper;

    public ClienteRepositoryJpa(ClienteJpaRepository clienteJpaRepository, ClienteMapper clienteMapper) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.clienteMapper = clienteMapper;
    }


    // METODOS 

    @Override
    public Optional<Cliente> buscarPorId(String clienteId){
        return clienteJpaRepository.findByClienteId(clienteId)
            .map(clienteMapper::aDominio);
    }

    @Override
    public void guardar(Cliente cliente){

        ClienteEntity entityExistente = clienteJpaRepository.findByClienteId(cliente.getClienteId().getValor()).orElse(null);
        ClienteEntity clienteEntity = clienteMapper.aEntity(cliente, entityExistente);
        
        if(clienteEntity != null){

         clienteJpaRepository.save(clienteEntity);
         System.out.println(" Cliente guardado exitosamente");
        }

        
    }

    @Override
    public void actualizar(Cliente cliente){
        guardar(cliente);
    }

    @Override
    public boolean existePorEmail(String email){
        return clienteJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existePorEmailExcluyendo(String email, String clienteId){
        return clienteJpaRepository.existsByEmailAndClienteIdNot(email, clienteId);
    }



}
