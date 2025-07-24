package com.apartment.maintenance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.maintenance.entity.Society;
import com.apartment.maintenance.repository.SocietyRepository;
import com.apartment.maintenance.service.interfaces.SocietyService;

@Service
public class SocietyServiceImpl implements SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    @Override
    public Society addSociety(Society society) {
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
    
}
