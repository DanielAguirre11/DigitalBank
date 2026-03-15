package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarTransactionCodeRequest;
import com.banco.application.dto.TransactionCodeRequest;
import com.banco.application.dto.TransactionCodeResponse;
import com.banco.application.services.GestionTransactionCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transaction-code")
@Tag(name = "Transaction Codes", description = "Gestion de codigos de transaccion")
public class TransactionCodeController {

    private final GestionTransactionCodeService service;

    public TransactionCodeController(GestionTransactionCodeService service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "Crear codigo de transaccion")
    public ResponseEntity<TransactionCodeResponse> crear(
            @Valid @RequestBody TransactionCodeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearTransactionCode(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar codigo de transaccion por ID")
    public ResponseEntity<TransactionCodeResponse> buscarPorId(@PathVariable Short id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos los codigos de transaccion")
    public ResponseEntity<List<TransactionCodeResponse>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar codigo de transaccion")
    public ResponseEntity<TransactionCodeResponse> actualizar(
            @PathVariable Short id,
            @RequestBody ActualizarTransactionCodeRequest request) {
        return ResponseEntity.ok(service.actualizarTransactionCode(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar codigo de transaccion")
    public ResponseEntity<Void> eliminar(@PathVariable Short id) {
        service.eliminarTransactionCode(id);
        return ResponseEntity.noContent().build();
    }
}
