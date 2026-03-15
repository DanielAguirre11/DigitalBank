package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarProductRequest;
import com.banco.application.dto.ProductRequest;
import com.banco.application.dto.ProductResponse;
import com.banco.application.services.GestionProductService;
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

@Tag(name = "Products", description = "Gestion de productos: crear, consultar, actualizar y eliminar")
@RestController
@RequestMapping("api/product")
public class ProductController {

    private final GestionProductService service;

    public ProductController(GestionProductService service) {
        this.service = service;
    }

    @Operation(summary = "Crear producto", description = "Registra un nuevo producto en el sistema")
    @PostMapping
    public ResponseEntity<ProductResponse> crearProduct(@Valid @RequestBody ProductRequest request) {
        ProductResponse response = service.crearProduct(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header("Location", "api/product/" + response.getProductId())
            .body(response);
    }

    @Operation(summary = "Obtener producto", description = "Busca un producto por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> obtenerProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Listar productos por familia", description = "Retorna todos los productos de una familia especifica")
    @GetMapping("/family/{familyId}")
    public ResponseEntity<List<ProductResponse>> listarPorFamilia(@PathVariable Short familyId) {
        return ResponseEntity.ok(service.buscarPorFamilyId(familyId));
    }

    @Operation(summary = "Listar todos los productos", description = "Retorna todos los productos registrados en el sistema")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> listarProducts() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @Operation(summary = "Actualizar producto", description = "Modifica los datos de un producto existente")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> actualizarProduct(
            @PathVariable Integer id,
            @RequestBody ActualizarProductRequest request) {
        return ResponseEntity.ok(service.actualizarProduct(id, request));
    }

    @Operation(summary = "Eliminar producto", description = "Elimina un producto del sistema")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarProduct(@PathVariable Integer id) {
        service.eliminarProduct(id);
        return ResponseEntity.noContent().build();
    }
}
