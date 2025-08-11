package com.apartment.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.maintenance.dto.AddFlatRequestDTO;
import com.apartment.maintenance.dto.FlatResponseDTO;
import com.apartment.maintenance.service.interfaces.FlatService;

@RestController
@RequestMapping("/api/flats")
@CrossOrigin(origins = "*") // Adjust if needed
public class FlatController {

    @Autowired
    private FlatService flatService;

    @PostMapping
    public ResponseEntity<?> addFlat(@RequestBody AddFlatRequestDTO request) {
        try {
            flatService.addFlat(request);
            return ResponseEntity.ok("Flat added successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{buildingId}")
    public ResponseEntity<List<FlatResponseDTO>> getFlats(@PathVariable Long buildingId) {
        List<FlatResponseDTO> flats = flatService.getFlatsByBuildingId(buildingId);
        return ResponseEntity.ok(flats);
    }
}
