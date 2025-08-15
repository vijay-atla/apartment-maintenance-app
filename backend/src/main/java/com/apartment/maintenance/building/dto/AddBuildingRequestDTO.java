package com.apartment.maintenance.building.dto;

public class AddBuildingRequestDTO {

    private String name;
    private Integer numberOfFloors;
    private Boolean liftAvailable;
    private Long societyId;

    public AddBuildingRequestDTO() {
    }

    public AddBuildingRequestDTO(String name, Integer numberOfFloors, Boolean liftAvailable, Long societyId) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.liftAvailable = liftAvailable;
        this.societyId = societyId;
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
}
