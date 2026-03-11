package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarPartnerLocationRequest;
import com.banco.application.dto.PartnerLocationRequest;
import com.banco.application.dto.PartnerLocationResponse;
import com.banco.application.services.GestionPartnerLocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Partner Locations", description = "Partner location management: create, get, update and delete")
@RestController
@RequestMapping("api/partner-location")
public class PartnerLocationController {

    private final GestionPartnerLocationService gestionPartnerLocationService;

    public PartnerLocationController(GestionPartnerLocationService gestionPartnerLocationService) {
        this.gestionPartnerLocationService = gestionPartnerLocationService;
    }


    @Operation(summary = "Create partner location", description = "Registers a new location for a partner")
    @PostMapping
    public ResponseEntity<PartnerLocationResponse> crearPartnerLocation(
            @Valid @RequestBody PartnerLocationRequest request) {
        PartnerLocationResponse response = gestionPartnerLocationService.crearPartnerLocation(request);
        URI location = URI.create("api/partner-location/" + response.getPartnerLocationId());
        return ResponseEntity.created(location).body(response);
    }


    @Operation(summary = "Get partner location", description = "Finds a partner location by ID")
    @GetMapping("/{id}")
    public ResponseEntity<PartnerLocationResponse> obtenerPartnerLocation(@PathVariable Long id) {
        return ResponseEntity.ok(gestionPartnerLocationService.buscarPartnerLocationPorId(id));
    }


    @Operation(summary = "List by partner", description = "Returns all locations for a given partner")
    @GetMapping("/partner/{partnerId}")
    public ResponseEntity<List<PartnerLocationResponse>> listarPorPartner(@PathVariable Long partnerId) {
        return ResponseEntity.ok(gestionPartnerLocationService.buscarPorPartnerId(partnerId));
    }


    @Operation(summary = "Update partner location", description = "Updates the address data of a partner location")
    @PutMapping("/{id}")
    public ResponseEntity<PartnerLocationResponse> actualizarPartnerLocation(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarPartnerLocationRequest request) {
        return ResponseEntity.ok(gestionPartnerLocationService.actualizarPartnerLocation(id, request));
    }


    @Operation(summary = "Delete partner location", description = "Removes a partner location")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarPartnerLocation(@PathVariable Long id) {
        gestionPartnerLocationService.eliminarPartnerLocation(id);
        return ResponseEntity.noContent().build();
    }
}
