package com.apartment.maintenance.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.maintenance.dto.AddFlatRequestDTO;
import com.apartment.maintenance.dto.FlatResponseDTO;
import com.apartment.maintenance.entity.Building;
import com.apartment.maintenance.entity.Flat;
import com.apartment.maintenance.repository.BuildingRepository;
import com.apartment.maintenance.repository.FlatRepository;
import com.apartment.maintenance.service.interfaces.FlatService;

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
