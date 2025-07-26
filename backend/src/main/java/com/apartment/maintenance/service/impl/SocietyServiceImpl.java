package com.apartment.maintenance.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.maintenance.dto.AddSocietyRequestDTO;
import com.apartment.maintenance.entity.Address;
import com.apartment.maintenance.entity.Society;
import com.apartment.maintenance.entity.User;
import com.apartment.maintenance.repository.SocietyRepository;
import com.apartment.maintenance.repository.UserRepository;
import com.apartment.maintenance.service.interfaces.SocietyService;

@Service
public class SocietyServiceImpl implements SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Society addSociety(AddSocietyRequestDTO request) {

        User admin = userRepository.findById(request.getAdminId())
        .orElseThrow(() -> new RuntimeException("Admin not found"));

        Society society = new Society();

        // Capitalize important fields
        society.setName(capitalizeWords(request.getName()));
        society.setType(request.getType().toUpperCase());

        if (request.getAddress() != null) {
            Address address = request.getAddress();
            address.setState(capitalizeWords(address.getState()));
            address.setDistrict(capitalizeWords(address.getDistrict()));
            address.setCity(capitalizeWords(address.getCity()));
            address.setLocality(capitalizeWords(address.getLocality()));
            address.setStreet(capitalizeWords(address.getStreet()));
            address.setAddress(capitalizeWords(address.getAddress()));
            address.setCountry(capitalizeWords(address.getCountry()));
            society.setAddress(address);
        }

        // Map admin to society
        if (society.getAdmins() == null) {
            society.setAdmins(new ArrayList<>());
        }
        society.getAdmins().add(admin);
        
        return societyRepository.save(society);
    }

    @Override
    public List<Society> getAllSocieties() {
        return societyRepository.findAll();
    }

    @Override
    public List<Society> getSocietiesByAdminId(Long adminId) {
        return societyRepository.findByAdminId(adminId);
    }

    private String capitalizeWords(String input) {
        if (input == null || input.trim().isEmpty()) return input;

        return Arrays.stream(input.trim().toLowerCase().split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    
}
