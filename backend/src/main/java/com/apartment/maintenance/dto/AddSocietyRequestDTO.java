package com.apartment.maintenance.dto;

import com.apartment.maintenance.entity.Address;

public class AddSocietyRequestDTO {
    private String name;
    private String type;
    private Address address;
    private Long adminId;

    public AddSocietyRequestDTO() {}

    public AddSocietyRequestDTO(String name, String type, Address address, Long adminId) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.adminId = adminId;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
