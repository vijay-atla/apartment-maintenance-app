package com.apartment.maintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.maintenance.entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    
    // Get all buildings in a given society
    List<Building> findBySocietyId(Long societyId);

    // Optional: in case you need flat count later
    // @Query("SELECT COUNT(f) FROM Flat f WHERE f.building.id = :buildingId")
    // int countFlatsByBuildingId(@Param("buildingId") Long buildingId);
}
