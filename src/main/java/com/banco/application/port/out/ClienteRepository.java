package com.banco.application.port.out;

import java.util.Optional;

import com.banco.domain.model.entities.Cliente;


public interface ClienteRepository {

    // GUARDAR
     void guardar(Cliente cliente);

    // BUSCAR POR ID
    Optional<Cliente> buscarPorId(String clienteId);

    // VALIDAR EXISTENCIA POR EMAIL
    boolean existePorEmail(String email);

    // VALIDAR EXISTENCIA POR EMAIL EXCLUYENDO UN CLIENTE
    boolean existePorEmailExcluyendo(String email, String clienteId);

    // ACTUALIZAR
    void actualizar(Cliente cliente);


}
