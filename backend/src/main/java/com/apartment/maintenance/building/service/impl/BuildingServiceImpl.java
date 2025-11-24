package com.apartment.maintenance.building.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.maintenance.building.dto.AddBuildingRequestDTO;
import com.apartment.maintenance.building.dto.BuildingResponseDTO;
import com.apartment.maintenance.building.entity.Building;
import com.apartment.maintenance.building.repository.BuildingRepository;
import com.apartment.maintenance.building.service.BuildingService;
import com.apartment.maintenance.society.entity.Society;
import com.apartment.maintenance.society.repository.SocietyRepository;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private SocietyRepository societyRepository;

    // @Autowired
    // private FlatRepository flatRepository;

    @Override
    public void addBuilding(AddBuildingRequestDTO dto) {
        Society society = societyRepository.findById(dto.getSocietyId())
                .orElseThrow(() -> new RuntimeException("Society not found"));

        Building building = new Building();
        building.setName(dto.getName());
        building.setNumberOfFloors(dto.getNumberOfFloors());
        building.setLiftAvailable(dto.getLiftAvailable());
        building.setSociety(society);

        buildingRepository.save(building);
    }

    @Override
    public List<BuildingResponseDTO> getBuildingsBySocietyId(Long societyId) {
        List<Building> buildings = buildingRepository.findBySocietyId(societyId);

        return buildings.stream().map(b -> {
            int totalUnits = 0; //flatRepository.countByBuildingId(b.getId());

            return new BuildingResponseDTO(
                    b.getId(),
                    b.getName(),
                    b.getNumberOfFloors(),
                    b.getLiftAvailable(),
                    b.getSociety().getId(),
                    b.getSociety().getName(),
                    totalUnits
            );
        }).collect(Collectors.toList());
    }
}
