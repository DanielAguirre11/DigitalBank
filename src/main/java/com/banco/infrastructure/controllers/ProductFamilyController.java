package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarProductFamilyRequest;
import com.banco.application.dto.ProductFamilyRequest;
import com.banco.application.dto.ProductFamilyResponse;
import com.banco.application.services.GestionProductFamilyService;
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

@Tag(name = "Product Families", description = "Gestion de familias de productos: crear, consultar, actualizar y eliminar")
@RestController
@RequestMapping("api/product-family")
public class ProductFamilyController {

    private final GestionProductFamilyService service;

    public ProductFamilyController(GestionProductFamilyService service) {
        this.service = service;
    }

    @Operation(summary = "Crear familia de productos", description = "Registra una nueva familia de productos en el sistema")
    @PostMapping
    public ResponseEntity<ProductFamilyResponse> crearProductFamily(@Valid @RequestBody ProductFamilyRequest request) {
        ProductFamilyResponse response = service.crearProductFamily(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header("Location", "api/product-family/" + response.getFamilyId())
            .body(response);
    }

    @Operation(summary = "Obtener familia de productos", description = "Busca una familia de productos por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductFamilyResponse> obtenerProductFamily(@PathVariable Short id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Listar familias de productos", description = "Retorna todas las familias de productos registradas")
    @GetMapping
    public ResponseEntity<List<ProductFamilyResponse>> listarProductFamilies() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @Operation(summary = "Actualizar familia de productos", description = "Modifica los datos de una familia de productos existente")
    @PutMapping("/{id}")
    public ResponseEntity<ProductFamilyResponse> actualizarProductFamily(
            @PathVariable Short id,
            @RequestBody ActualizarProductFamilyRequest request) {
        return ResponseEntity.ok(service.actualizarProductFamily(id, request));
    }

    @Operation(summary = "Eliminar familia de productos", description = "Elimina una familia de productos del sistema")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarProductFamily(@PathVariable Short id) {
        service.eliminarProductFamily(id);
        return ResponseEntity.noContent().build();
    }
}
