package com.apartment.maintenance.service.interfaces;

import java.util.List;

import com.apartment.maintenance.dto.AddBuildingRequestDTO;
import com.apartment.maintenance.dto.BuildingResponseDTO;

public interface BuildingService {
    void addBuilding(AddBuildingRequestDTO dto);

    List<BuildingResponseDTO> getBuildingsBySocietyId(Long societyId);
}
