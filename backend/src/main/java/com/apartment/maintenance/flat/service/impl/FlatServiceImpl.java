package com.apartment.maintenance.flat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.maintenance.building.entity.Building;
import com.apartment.maintenance.building.repository.BuildingRepository;
import com.apartment.maintenance.flat.dto.AddFlatRequestDTO;
import com.apartment.maintenance.flat.dto.FlatResponseDTO;
import com.apartment.maintenance.flat.entity.Flat;
import com.apartment.maintenance.flat.repository.FlatRepository;
import com.apartment.maintenance.flat.service.FlatService;

@Service
public class FlatServiceImpl implements FlatService {

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void addFlat(AddFlatRequestDTO dto) {
        Building building = buildingRepository.findById(dto.getBuildingId())
                .orElseThrow(() -> new RuntimeException("Building not found"));

        Flat flat = new Flat();
        flat.setFlatNumber(dto.getFlatNumber());
        flat.setFloorNumber(dto.getFloorNumber());
        flat.setFlatType(dto.getFlatType());
        flat.setBuilding(building);

        flatRepository.save(flat);
    }

    @Override
    public List<FlatResponseDTO> getFlatsByBuildingId(Long buildingId) {
        List<Flat> flats = flatRepository.findByBuildingId(buildingId);

        return flats.stream().map(flat -> new FlatResponseDTO(
                flat.getId(),
                flat.getFlatNumber(),
                flat.getFloorNumber(),
                flat.getFlatType(),
                flat.getBuilding().getId(),
                flat.getBuilding().getName()
        )).collect(Collectors.toList());
    }
}
