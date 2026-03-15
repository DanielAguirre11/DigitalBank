package com.banco.infrastructure.controllers;

import com.banco.application.dto.AccountHolderRequest;
import com.banco.application.dto.AccountHolderResponse;
import com.banco.application.dto.ActualizarAccountHolderRequest;
import com.banco.application.services.GestionAccountHolderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/account-holder")
@Tag(name = "Account Holders", description = "Gestion de titulares de cuentas")
public class AccountHolderController {

    private final GestionAccountHolderService service;

    public AccountHolderController(GestionAccountHolderService service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "Crear titular de cuenta")
    public ResponseEntity<AccountHolderResponse> crear(@Valid @RequestBody AccountHolderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearAccountHolder(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar titular por ID")
    public ResponseEntity<AccountHolderResponse> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/account/{accountId}")
    @Operation(summary = "Buscar titulares por cuenta")
    public ResponseEntity<List<AccountHolderResponse>> buscarPorAccountId(@PathVariable UUID accountId) {
        return ResponseEntity.ok(service.buscarPorAccountId(accountId));
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Buscar titulares por cliente")
    public ResponseEntity<List<AccountHolderResponse>> buscarPorCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok(service.buscarPorCustomerId(customerId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar titular de cuenta")
    public ResponseEntity<AccountHolderResponse> actualizar(
            @PathVariable UUID id,
            @RequestBody ActualizarAccountHolderRequest request) {
        return ResponseEntity.ok(service.actualizarAccountHolder(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar titular de cuenta")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        service.eliminarAccountHolder(id);
        return ResponseEntity.noContent().build();
    }
}
