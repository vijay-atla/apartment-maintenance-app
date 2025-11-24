package com.apartment.maintenance.building.controller;

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

import com.apartment.maintenance.building.dto.AddBuildingRequestDTO;
import com.apartment.maintenance.building.dto.BuildingResponseDTO;
import com.apartment.maintenance.building.service.BuildingService;

@RestController
@RequestMapping("/api/buildings")
@CrossOrigin(origins = "*")  // you can tighten this later
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity<?> addBuilding(@RequestBody AddBuildingRequestDTO request) {
        try {
            buildingService.addBuilding(request);
            return ResponseEntity.ok("Building created successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{societyId}")
    public ResponseEntity<List<BuildingResponseDTO>> getBuildings(@PathVariable Long societyId) {
        List<BuildingResponseDTO> buildings = buildingService.getBuildingsBySocietyId(societyId);
        return ResponseEntity.ok(buildings);
    }
}
