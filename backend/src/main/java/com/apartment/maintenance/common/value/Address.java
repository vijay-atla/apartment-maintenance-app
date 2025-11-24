package com.apartment.maintenance.common.value;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String state;
    private String district;
    private String city;
    private String locality;
    private String street;
    private String address;   // door no., landmark
    private String pinCode;
    private String country;

    public Address() {}

    // Getters and Setters
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getLocality() { return locality; }
    public void setLocality(String locality) { this.locality = locality; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPinCode() { return pinCode; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
