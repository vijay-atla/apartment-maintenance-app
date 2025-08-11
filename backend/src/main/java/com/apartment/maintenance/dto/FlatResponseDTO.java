package com.apartment.maintenance.dto;

public class FlatResponseDTO {

    private Long id;
    private String flatNumber;
    private Integer floorNumber;
    private String flatType;
    private Long buildingId;
    private String buildingName;

    public FlatResponseDTO() {
    }

    public FlatResponseDTO(Long id, String flatNumber, Integer floorNumber, String flatType,
                           Long buildingId, String buildingName) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.floorNumber = floorNumber;
        this.flatType = flatType;
        this.buildingId = buildingId;
        this.buildingName = buildingName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
