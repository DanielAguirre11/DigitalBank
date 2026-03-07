package com.banco.application.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banco.application.dto.ActualizarClienteRequest;
import com.banco.application.dto.ClienteRequest;
import com.banco.application.dto.ClienteResponse;
import com.banco.application.port.out.ClienteRepository;
import com.banco.domain.model.entities.Cliente;
import com.banco.domain.model.valueobjects.ClienteId;
import com.banco.domain.model.valueobjects.CuentaId;


@Service
@Transactional
public class GestionClienteService {

    private final ClienteRepository clienteRepository;

    // CONSTRUCTOR
    public GestionClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    // METODOS BASICOS

    public ClienteResponse crearCliente(ClienteRequest request){

        validarEmailNuevo(request.getEmail());

        ClienteId clienteId = ClienteId.generarNuevoId();
        Cliente cliente = new Cliente(clienteId, request.getNombre(), request.getEmail());

        clienteRepository.guardar(cliente);
        return convertirResponse(cliente);
    }

    public ClienteResponse buscarClientePorId(String clienteId){
        Cliente cliente = buscarOFallar(clienteId);
        return convertirResponse(cliente);
    }

    public ClienteResponse actualizarCliente(String clienteId, ActualizarClienteRequest request){

        Cliente clienteDB = buscarOFallar(clienteId);

        String nuevoEmail = request.getEmail().get();
        // Solo validar unicidad si el email cambio
        if (!nuevoEmail.equals(clienteDB.getEmail())) {
            validarEmailNuevo(nuevoEmail);
        }

        clienteDB.setNombre(request.getNombre().get());
        clienteDB.setEmail(nuevoEmail);

        clienteRepository.actualizar(clienteDB);
        return convertirResponse(clienteDB);
    }

    public void descativarCliente(String clienteStr){

        Cliente cliente = buscarOFallar(clienteStr);

        if(!cliente.getCuentas().isEmpty()) throw new IllegalArgumentException(
            "No se puede desactivar cliente con cuentas activas: " + cliente.getCuentas().size());

        cliente.desactivar();
        clienteRepository.actualizar(cliente);
    }

    public void activarCliente(String clienteStr){
        Cliente cliente = buscarOFallar(clienteStr);
        cliente.activar();
        clienteRepository.actualizar(cliente);
    }

    public void agregarCuentaAcliente(String clienteIdStr, String cuentaStr){
        CuentaId cuentaId = CuentaId.newCuentaId(cuentaStr);
        Cliente cliente = buscarOFallar(clienteIdStr);
        cliente.agregarCuenta(cuentaId); // el dominio valida limite y duplicados
        clienteRepository.actualizar(cliente);
    }

    public void removerCuentaAcliente(String clienteIdStr, String cuentaStr){
        CuentaId cuentaId = CuentaId.newCuentaId(cuentaStr);
        Cliente cliente = buscarOFallar(clienteIdStr);
        cliente.eliminarCuenta(cuentaId); // el dominio valida existencia
        clienteRepository.actualizar(cliente);
    }

    public ClienteResponse convertirResponse(Cliente cliente){

        return new ClienteResponse(
            cliente.getClienteId().getValor(),
            cliente.getNombre(),
            cliente.getEmail(),
            cliente.getActiva(),
            cliente.getCuentas().size(),
            cliente.getMaxCuentas(),
            cliente.getCuentas().stream().map(CuentaId::getValor).collect(Collectors.toList()),
            cliente.getCreatedAt(),
            cliente.getUpdatedAt());
    }


    // VALIDACIONES

    private void validarEmailNuevo(String email){
        if(clienteRepository.existePorEmail(email)){
            throw new IllegalArgumentException("El Email: " + email + " ya esta registrado");
        }
    }

    private Cliente buscarOFallar(String clienteIdStr){
        ClienteId clienteId = ClienteId.newCliente(clienteIdStr);
        return clienteRepository.buscarPorId(clienteIdStr)
            .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado: " + clienteId));
    }

}
