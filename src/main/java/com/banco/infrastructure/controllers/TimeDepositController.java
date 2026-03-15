package com.banco.infrastructure.controllers;

import com.banco.application.dto.TimeDepositRequest;
import com.banco.application.dto.TimeDepositResponse;
import com.banco.application.services.GestionTimeDepositService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/time-deposit")
@Tag(name = "Time Deposits", description = "Gestion de depositos a plazo fijo")
public class TimeDepositController {

    private final GestionTimeDepositService service;

    public TimeDepositController(GestionTimeDepositService service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "Crear deposito a plazo fijo")
    public ResponseEntity<TimeDepositResponse> crear(@Valid @RequestBody TimeDepositRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearTimeDeposit(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar deposito por ID")
    public ResponseEntity<TimeDepositResponse> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/account/{accountId}")
    @Operation(summary = "Buscar depositos por cuenta")
    public ResponseEntity<List<TimeDepositResponse>> buscarPorAccountId(@PathVariable UUID accountId) {
        return ResponseEntity.ok(service.buscarPorAccountId(accountId));
    }
}
