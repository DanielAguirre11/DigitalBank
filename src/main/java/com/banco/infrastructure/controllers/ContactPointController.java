package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarContactPointRequest;
import com.banco.application.dto.ContactPointRequest;
import com.banco.application.dto.ContactPointResponse;
import com.banco.application.services.GestionContactPointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Contact Points", description = "Contact point management: create, get, update and delete")
@RestController
@RequestMapping("api/contact-point")
public class ContactPointController {

    private final GestionContactPointService gestionContactPointService;

    public ContactPointController(GestionContactPointService gestionContactPointService) {
        this.gestionContactPointService = gestionContactPointService;
    }


    @Operation(summary = "Create contact point", description = "Creates a new contact point for a party")
    @PostMapping
    public ResponseEntity<ContactPointResponse> crearContactPoint(
            @Valid @RequestBody ContactPointRequest request) {
        ContactPointResponse response = gestionContactPointService.crearContactPoint(request);
        URI location = URI.create("api/contact-point/" + response.getContactPointId());
        return ResponseEntity.created(location).body(response);
    }


    @Operation(summary = "Get contact point", description = "Finds a contact point by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ContactPointResponse> obtenerContactPoint(@PathVariable Long id) {
        return ResponseEntity.ok(gestionContactPointService.buscarContactPointPorId(id));
    }


    @Operation(summary = "List by party", description = "Returns all contact points for a given party")
    @GetMapping("/party/{partyId}")
    public ResponseEntity<List<ContactPointResponse>> listarPorParty(@PathVariable Integer partyId) {
        return ResponseEntity.ok(gestionContactPointService.buscarPorPartyId(partyId));
    }


    @Operation(summary = "Update contact point", description = "Updates the data of an existing contact point")
    @PutMapping("/{id}")
    public ResponseEntity<ContactPointResponse> actualizarContactPoint(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarContactPointRequest request) {
        return ResponseEntity.ok(gestionContactPointService.actualizarContactPoint(id, request));
    }


    @Operation(summary = "Delete contact point", description = "Removes a contact point from the system")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarContactPoint(@PathVariable Long id) {
        gestionContactPointService.eliminarContactPoint(id);
        return ResponseEntity.noContent().build();
    }
}
