package com.apartment.maintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.maintenance.entity.Flat;

public interface FlatRepository extends JpaRepository<Flat, Long> {

    // Get all flats in a building
    List<Flat> findByBuildingId(Long buildingId);

    // Count flats in a building (used for totalUnits in building)
    int countByBuildingId(Long buildingId);
}
