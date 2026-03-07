package com.banco.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.banco.application.dto.AperturaCuentaRequest;
import com.banco.application.dto.AperturaCuentaResponse;
import com.banco.application.dto.ConsultaSaldoRequest;
import com.banco.application.dto.ConsultaSaldoResponse;

import com.banco.application.services.AperturaCuentaService;
import com.banco.application.services.ConsultaSaldoService;

import jakarta.validation.Valid;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name = "Cuentas", description = "Gestion de cuentas bancarias: apertura, consulta de saldo y cierre")
@RestController
@RequestMapping("api/cuentas")
public class CuentaController {

    // ATRIBUTOS
    private final AperturaCuentaService aperturaCuentaService;
    private final ConsultaSaldoService consultaSaldoService;

    public CuentaController(AperturaCuentaService aperturaCuentaService, ConsultaSaldoService consultaSaldoService) {
        this.aperturaCuentaService = aperturaCuentaService;
        this.consultaSaldoService = consultaSaldoService;
    }


    @Operation(summary = "Abrir cuenta", description = "Crea una nueva cuenta bancaria para un cliente")
    @PostMapping()
    public ResponseEntity<AperturaCuentaResponse> abrirCuenta(@Valid @RequestBody AperturaCuentaRequest request){
        AperturaCuentaResponse response = aperturaCuentaService.ejecutarAperturaCuenta(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Consultar saldo", description = "Consulta el saldo actual de una cuenta")
    @GetMapping("/{cuentaId}/saldo")
    public ResponseEntity<ConsultaSaldoResponse> consultaSaldo(
            @PathVariable String cuentaId,
            @RequestParam(required = false) LocalDate fechaDesde,
            @RequestParam(required = false) LocalDate fechaHasta,
            @RequestParam(defaultValue = "true") boolean incluirMovimientos,
            @RequestParam(defaultValue = "10") int limiteMovimientos){

        ConsultaSaldoRequest request = new ConsultaSaldoRequest(
            cuentaId, fechaDesde, fechaHasta, incluirMovimientos, limiteMovimientos);

        return ResponseEntity.ok(consultaSaldoService.consultarSaldo(request));
    }

    @Operation(summary = "Cerrar cuenta", description = "Cierra una cuenta bancaria existente")
    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<Void> cerrarCuenta(@PathVariable String cuentaId){
        aperturaCuentaService.cerrarCuenta(cuentaId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Reactivar cuenta", description = "Reactiva una cuenta previamente cerrada")
    @PutMapping("/{cuentaId}/activar")
    public ResponseEntity<Void> reactivarCuenta(@PathVariable String cuentaId){
        aperturaCuentaService.abrirCuenta(cuentaId);
        return ResponseEntity.noContent().build();
    }

}
