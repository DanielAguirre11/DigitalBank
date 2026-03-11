package com.banco.infrastructure.controllers;

import com.banco.application.dto.ActualizarProfileRequest;
import com.banco.application.dto.ProfileRequest;
import com.banco.application.dto.ProfileResponse;
import com.banco.application.services.GestionProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Profiles", description = "Partner profile management: create, get, update and delete")
@RestController
@RequestMapping("api/profile")
public class ProfileController {

    private final GestionProfileService gestionProfileService;

    public ProfileController(GestionProfileService gestionProfileService) {
        this.gestionProfileService = gestionProfileService;
    }


    @Operation(summary = "Create profile", description = "Creates a new profile for a partner")
    @PostMapping
    public ResponseEntity<ProfileResponse> crearProfile(@Valid @RequestBody ProfileRequest request) {
        ProfileResponse response = gestionProfileService.crearProfile(request);
        URI location = URI.create("api/profile/" + response.getProfileId());
        return ResponseEntity.created(location).body(response);
    }


    @Operation(summary = "Get profile", description = "Finds a profile by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> obtenerProfile(@PathVariable Long id) {
        return ResponseEntity.ok(gestionProfileService.buscarProfilePorId(id));
    }


    @Operation(summary = "List by partner", description = "Returns all profiles for a given partner")
    @GetMapping("/partner/{partnerId}")
    public ResponseEntity<List<ProfileResponse>> listarPorPartner(@PathVariable Long partnerId) {
        return ResponseEntity.ok(gestionProfileService.buscarPorPartnerId(partnerId));
    }


    @Operation(summary = "Update profile", description = "Updates the data of an existing profile")
    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponse> actualizarProfile(@PathVariable Long id,
                                                             @Valid @RequestBody ActualizarProfileRequest request) {
        return ResponseEntity.ok(gestionProfileService.actualizarProfile(id, request));
    }


    @Operation(summary = "Delete profile", description = "Removes a profile from the system")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarProfile(@PathVariable Long id) {
        gestionProfileService.eliminarProfile(id);
        return ResponseEntity.noContent().build();
    }
}
