package com.banco.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

        return ResponseEntity
        .status(HttpStatus.OK)
        .body(new AperturaCuentaResponse(
            response.getCuentaId(), 
            response.getClienteId(), 
            response.getTipoCuenta(), 
            response.getMoneda(), 
            response.getSaldoInicial(), 
            response.getFechaApertura(), 
            "Cuenta creada exitosamente"));
    }

    @Operation(summary = "Consultar saldo", description = "Consulta el saldo actual de una cuenta")
    @GetMapping()
    public ResponseEntity<ConsultaSaldoResponse> consultaSaldo(@Valid @RequestBody ConsultaSaldoRequest request){


        ConsultaSaldoResponse response = consultaSaldoService.consultarSaldo(request);

        return ResponseEntity
        .ok(response);
    }

    @Operation(summary = "Cerrar cuenta", description = "Cierra una cuenta bancaria existente")
    @DeleteMapping("/{cuentaStringId}")
    public ResponseEntity<?> cerrarCuentas(@PathVariable String cuentaStringId){

        try {

            aperturaCuentaService.cerrarCuenta(cuentaStringId);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            throw new IllegalArgumentException("Hubo un error al intentar cerrar la cuenta: " + e.getMessage());
        }
    }

    @Operation(summary = "Reactivar cuenta", description = "Reactiva una cuenta previamente cerrada")
    @PostMapping("/{cuentaStringId}")
    public ResponseEntity<Void> abrirCuenta(@PathVariable String cuentaStringId){

        try {
            
            aperturaCuentaService.abrirCuenta(cuentaStringId);

            return ResponseEntity.ok().build();

        } catch (Exception e) {

            throw new IllegalArgumentException("Hubo un error: " + e.getMessage());
        }
    }
    
    

 
    
    
}
