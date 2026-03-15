package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarProductFeeRequest;
import com.banco.application.dto.ProductFeeRequest;
import com.banco.application.dto.ProductFeeResponse;
import com.banco.application.services.GestionProductFeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Product Fees", description = "Gestion de cargos de productos: crear, consultar, actualizar y eliminar")
@RestController
@RequestMapping("api/product-fee")
public class ProductFeeController {

    private final GestionProductFeeService service;

    public ProductFeeController(GestionProductFeeService service) {
        this.service = service;
    }

    @Operation(summary = "Crear cargo de producto", description = "Registra un nuevo cargo asociado a un producto")
    @PostMapping
    public ResponseEntity<ProductFeeResponse> crearProductFee(@Valid @RequestBody ProductFeeRequest request) {
        ProductFeeResponse response = service.crearProductFee(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header("Location", "api/product-fee/" + response.getFeeId())
            .body(response);
    }

    @Operation(summary = "Obtener cargo de producto", description = "Busca un cargo de producto por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductFeeResponse> obtenerProductFee(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Listar cargos por producto", description = "Retorna todos los cargos asociados a un producto especifico")
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductFeeResponse>> listarPorProducto(@PathVariable Integer productId) {
        return ResponseEntity.ok(service.buscarPorProductId(productId));
    }

    @Operation(summary = "Actualizar cargo de producto", description = "Modifica los datos de un cargo de producto existente")
    @PutMapping("/{id}")
    public ResponseEntity<ProductFeeResponse> actualizarProductFee(
            @PathVariable Integer id,
            @RequestBody ActualizarProductFeeRequest request) {
        return ResponseEntity.ok(service.actualizarProductFee(id, request));
    }

    @Operation(summary = "Eliminar cargo de producto", description = "Elimina un cargo de producto del sistema")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarProductFee(@PathVariable Integer id) {
        service.eliminarProductFee(id);
        return ResponseEntity.noContent().build();
    }
}
