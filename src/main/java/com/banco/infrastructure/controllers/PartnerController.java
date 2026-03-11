package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarPartnerRequest;
import com.banco.application.dto.PartnerRequest;
import com.banco.application.dto.PartnerResponse;
import com.banco.application.services.GestionPartnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Partners", description = "Partner management: create, get, update and delete")
@RestController
@RequestMapping("api/partner")
public class PartnerController {

    private final GestionPartnerService gestionPartnerService;

    public PartnerController(GestionPartnerService gestionPartnerService) {
        this.gestionPartnerService = gestionPartnerService;
    }


    @Operation(summary = "Create partner", description = "Registers a new partner in the system")
    @PostMapping
    public ResponseEntity<PartnerResponse> crearPartner(@Valid @RequestBody PartnerRequest request) {
        PartnerResponse response = gestionPartnerService.crearPartner(request);
        URI location = URI.create("api/partner/" + response.getPartnerId());
        return ResponseEntity.created(location).body(response);
    }


    @Operation(summary = "Get partner", description = "Finds a partner by ID")
    @GetMapping("/{id}")
    public ResponseEntity<PartnerResponse> obtenerPartner(@PathVariable Long id) {
        return ResponseEntity.ok(gestionPartnerService.buscarPartnerPorId(id));
    }


    @Operation(summary = "List partners", description = "Returns the list of all registered partners")
    @GetMapping
    public ResponseEntity<List<PartnerResponse>> listarPartners() {
        return ResponseEntity.ok(gestionPartnerService.buscarTodos());
    }


    @Operation(summary = "Update partner", description = "Updates the data of an existing partner")
    @PutMapping("/{id}")
    public ResponseEntity<PartnerResponse> actualizarPartner(@PathVariable Long id,
                                                             @Valid @RequestBody ActualizarPartnerRequest request) {
        return ResponseEntity.ok(gestionPartnerService.actualizarPartner(id, request));
    }


    @Operation(summary = "Delete partner", description = "Removes a partner from the system")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarPartner(@PathVariable Long id) {
        gestionPartnerService.eliminarPartner(id);
        return ResponseEntity.noContent().build();
    }
}
