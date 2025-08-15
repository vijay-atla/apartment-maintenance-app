package com.apartment.maintenance.building.service;

import java.util.List;

import com.apartment.maintenance.building.dto.AddBuildingRequestDTO;
import com.apartment.maintenance.building.dto.BuildingResponseDTO;

public interface BuildingService {
    void addBuilding(AddBuildingRequestDTO dto);

    List<BuildingResponseDTO> getBuildingsBySocietyId(Long societyId);
}
