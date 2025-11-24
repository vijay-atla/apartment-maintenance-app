package com.apartment.maintenance.building.dto;

public class BuildingResponseDTO {

    private Long id;
    private String name;
    private Integer numberOfFloors;
    private Boolean liftAvailable;
    private Long societyId;
    private String societyName;
    private int totalUnits;

    public BuildingResponseDTO() {
    }

    public BuildingResponseDTO(Long id, String name, Integer numberOfFloors, Boolean liftAvailable,
                               Long societyId, String societyName, int totalUnits) {
        this.id = id;
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.liftAvailable = liftAvailable;
        this.societyId = societyId;
        this.societyName = societyName;
        this.totalUnits = totalUnits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Boolean getLiftAvailable() {
        return liftAvailable;
    }

    public void setLiftAvailable(Boolean liftAvailable) {
        this.liftAvailable = liftAvailable;
    }

    public Long getSocietyId() {
        return societyId;
    }

    public void setSocietyId(Long societyId) {
        this.societyId = societyId;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }
}
