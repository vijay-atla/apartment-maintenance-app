package com.apartment.maintenance.society.entity;

import java.util.List;

import com.apartment.maintenance.common.value.Address;
import com.apartment.maintenance.user.entity.User;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Society {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // SMALL, MEDIUM, LARGE

    @Embedded
    private Address address;

    public Society() {}

    public Society(String name, String type, Address address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }

    @ManyToMany
    @JoinTable(
        name = "society_admins",
        joinColumns = @JoinColumn(name = "society_id"),
        inverseJoinColumns = @JoinColumn(name = "admin_id")
    )
    private List<User> admins;


    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<User> getAdmins() {
        return admins;
    }

    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }
}
