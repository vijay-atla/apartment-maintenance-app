package com.apartment.maintenance.flat.dto;

public class AddFlatRequestDTO {

    private String flatNumber;
    private Integer floorNumber;
    private String flatType;
    private Long buildingId;

    public AddFlatRequestDTO() {
    }

    public AddFlatRequestDTO(String flatNumber, Integer floorNumber, String flatType, Long buildingId) {
        this.flatNumber = flatNumber;
        this.floorNumber = floorNumber;
        this.flatType = flatType;
        this.buildingId = buildingId;
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
}
