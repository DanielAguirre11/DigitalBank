package com.banco.infrastructure.persistence.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.banco.domain.model.entities.Cliente;
import com.banco.domain.model.valueobjects.ClienteId;
import com.banco.domain.model.valueobjects.CuentaId;
import com.banco.infrastructure.persistence.entities.ClienteEntity;



@Component
public class ClienteMapper {
    
    //ClienteEntity a DOMINIO
    public Cliente aDominio(ClienteEntity entity){

        ClienteId clienteId = ClienteId.newCliente(entity.getClienteId());

        List<CuentaId> cuentaIds = entity.getCuentasIds().stream()
            .map(CuentaId::newCuentaId)
            .collect(Collectors.toList());

        Cliente cliente = new Cliente(
            clienteId,
            entity.getNombre(),
            entity.getEmail(),
            entity.isActiva(),
            cuentaIds,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );

        System.out.println("Cliente reconstruido desde BD: " + clienteId);
        return cliente;

    }


    // DE DOMINIO A ENTITY
    public ClienteEntity aEntity(Cliente dominio,ClienteEntity entityExistente){

        if(entityExistente == null){
            entityExistente = new ClienteEntity();
        }
        

        entityExistente.setClienteId(dominio.getClienteId().getValor());

        // Cada iteracion retorna su valor a string y luego lo almacenamos
        List<String> cuentasIdsString = dominio.getCuentas()
        .stream().map(dom -> dom.getValor()).collect(Collectors.toList());

        entityExistente.setCuentasIds(cuentasIdsString);
        entityExistente.setActiva(dominio.getActiva());
        entityExistente.setEmail(dominio.getEmail());
        entityExistente.setNombre(dominio.getNombre());
        entityExistente.setMaxCuentasPermitidas(dominio.getMaxCuentas());

        return entityExistente;
    }
}
