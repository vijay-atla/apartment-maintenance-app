package com.apartment.maintenance.society.service;

import java.util.List;

import com.apartment.maintenance.society.dto.AddSocietyRequestDTO;
import com.apartment.maintenance.society.entity.Society;

public interface SocietyService {
    Society addSociety(AddSocietyRequestDTO request);
    List<Society> getAllSocieties();
    List<Society> getSocietiesByAdminId(Long adminId);
}
