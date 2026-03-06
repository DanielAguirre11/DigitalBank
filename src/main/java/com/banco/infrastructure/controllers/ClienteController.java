package com.banco.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.banco.application.dto.ActualizarClienteRequest;
import com.banco.application.dto.ClienteRequest;
import com.banco.application.dto.ClienteResponse;
import com.banco.application.services.GestionClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;









@Tag(name = "Clientes", description = "Gestion de clientes: crear, consultar, actualizar y desactivar")
@RestController
@RequestMapping("api/clientes")
public class ClienteController {
    
    private GestionClienteService gestionClienteService;

    public ClienteController(GestionClienteService gestionClienteService) {
        this.gestionClienteService = gestionClienteService;
    }


    // GESTION CLIENTE
    
    @Operation(summary = "Crear cliente", description = "Registra un nuevo cliente en el sistema")
    @PostMapping()
    public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest entity) {
        
       ClienteResponse cliente = gestionClienteService.crearCliente(entity);

       // 🎯 Construimos respuesta HTTP completa
       return ResponseEntity
       .status(HttpStatus.CREATED)
       .header("Location", "api/cliente " + cliente.getClienteId())
       .body(cliente);
    }

    @Operation(summary = "Obtener cliente", description = "Busca un cliente por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerCliente(@PathVariable String id) {
        
        ClienteResponse cliente = gestionClienteService.buscarClientePorId(id);

        return ResponseEntity
        .status(HttpStatus.OK)
        .body(cliente);
    }

    @Operation(summary = "Actualizar cliente", description = "Modifica los datos de un cliente existente")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarCliente(@PathVariable String id, 
       @Valid @RequestBody ActualizarClienteRequest request){

        ClienteResponse cliente = gestionClienteService.actualizarCliente(id, request);

        return ResponseEntity
        .status(HttpStatus.OK).body(cliente);
    }

    @Operation(summary = "Desactivar cliente", description = "Desactiva un cliente (baja logica)")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> desactivarCliente(@PathVariable String id){

        gestionClienteService.descativarCliente(id);

        return ResponseEntity.noContent().build();
    }
    
    @Operation(summary = "Activar cliente", description = "Reactiva un cliente previamente desactivado")
    @PostMapping("/{id}/activar")
    public ResponseEntity<Void> activarCliente(@PathVariable String id){

        gestionClienteService.activarCliente(id);

        return ResponseEntity.noContent().build();
    }
    
    

    // GESTION CUENTA

    @Operation(summary = "Agregar cuenta a cliente", description = "Asocia una cuenta existente a un cliente")
    @PostMapping("{clienteId}/cuenta/{cuentaId}")
    public ResponseEntity<Void> agregarCuentaAcliente(@PathVariable String clienteId, 
       @PathVariable String cuentaId){

        gestionClienteService.agregarCuentaAcliente(clienteId, cuentaId);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Eliminar cuenta de cliente", description = "Desvincula una cuenta de un cliente")
    @DeleteMapping("{clienteId}/cuenta/{cuentaId}")
    public ResponseEntity<Void> eliminarCuentaAcliente(@PathVariable String clienteId, 
        @PathVariable String cuentaId) {

            gestionClienteService.removerCuentaAcliente(clienteId, cuentaId);

            return ResponseEntity.noContent().build();
        }

    @Operation(summary = "Obtener cuentas del cliente", description = "Lista todas las cuentas asociadas a un cliente")
    @GetMapping("{id}/cuenta")
    public ResponseEntity<List<String>> obtenerCuentasCliente(@PathVariable String id){

        ClienteResponse cliente = gestionClienteService.buscarClientePorId(id);

        return ResponseEntity.ok().body(cliente.getCuentaIds());
    }
    
    
}
