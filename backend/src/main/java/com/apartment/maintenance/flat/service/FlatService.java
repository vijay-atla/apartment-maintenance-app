package com.apartment.maintenance.flat.service;

import java.util.List;

import com.apartment.maintenance.flat.dto.AddFlatRequestDTO;
import com.apartment.maintenance.flat.dto.FlatResponseDTO;

public interface FlatService {

    void addFlat(AddFlatRequestDTO dto);

    List<FlatResponseDTO> getFlatsByBuildingId(Long buildingId);
}
