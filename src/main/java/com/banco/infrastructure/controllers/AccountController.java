package com.banco.infrastructure.controllers;

import com.banco.application.dto.AccountRequest;
import com.banco.application.dto.AccountResponse;
import com.banco.application.dto.ActualizarAccountRequest;
import com.banco.application.services.GestionAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/account")
@Tag(name = "Accounts", description = "Gestion de cuentas bancarias")
public class AccountController {

    private final GestionAccountService service;

    public AccountController(GestionAccountService service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "Crear cuenta bancaria")
    public ResponseEntity<AccountResponse> crear(@Valid @RequestBody AccountRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearAccount(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cuenta por ID")
    public ResponseEntity<AccountResponse> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/number/{accountNumber}")
    @Operation(summary = "Buscar cuenta por numero de cuenta")
    public ResponseEntity<AccountResponse> buscarPorNumero(@PathVariable String accountNumber) {
        return ResponseEntity.ok(service.buscarPorNumero(accountNumber));
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Buscar cuentas por cliente")
    public ResponseEntity<List<AccountResponse>> buscarPorCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok(service.buscarPorCustomerId(customerId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar cuenta bancaria")
    public ResponseEntity<AccountResponse> actualizar(
            @PathVariable UUID id,
            @RequestBody ActualizarAccountRequest request) {
        return ResponseEntity.ok(service.actualizarAccount(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cuenta bancaria")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        service.eliminarAccount(id);
        return ResponseEntity.noContent().build();
    }
}
