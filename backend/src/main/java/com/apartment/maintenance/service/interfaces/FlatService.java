package com.apartment.maintenance.service.interfaces;

import java.util.List;

import com.apartment.maintenance.dto.AddFlatRequestDTO;
import com.apartment.maintenance.dto.FlatResponseDTO;

public interface FlatService {

    void addFlat(AddFlatRequestDTO dto);

    List<FlatResponseDTO> getFlatsByBuildingId(Long buildingId);
}
