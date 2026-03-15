package com.banco.infrastructure.controllers;

import com.banco.application.dto.TransactionRequest;
import com.banco.application.dto.TransactionResponse;
import com.banco.application.services.GestionTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/transaction")
@Tag(name = "Transactions", description = "Gestion de transacciones bancarias")
public class TransactionController {

    private final GestionTransactionService service;

    public TransactionController(GestionTransactionService service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "Registrar transaccion bancaria")
    public ResponseEntity<TransactionResponse> crear(@Valid @RequestBody TransactionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearTransaccion(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar transaccion por ID")
    public ResponseEntity<TransactionResponse> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/account/{accountId}")
    @Operation(summary = "Listar transacciones por cuenta (orden descendente por fecha)")
    public ResponseEntity<List<TransactionResponse>> buscarPorAccountId(@PathVariable UUID accountId) {
        return ResponseEntity.ok(service.buscarPorAccountId(accountId));
    }

    @PostMapping("/{id}/reversal")
    @Operation(summary = "Revertir transaccion")
    public ResponseEntity<TransactionResponse> revertir(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.revertirTransaccion(id));
    }
}
