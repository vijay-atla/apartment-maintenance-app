package com.apartment.maintenance.service.interfaces;

import java.util.List;

import com.apartment.maintenance.dto.AddSocietyRequestDTO;
import com.apartment.maintenance.entity.Society;

public interface SocietyService {
    Society addSociety(AddSocietyRequestDTO request);
    List<Society> getAllSocieties();
    List<Society> getSocietiesByAdminId(Long adminId);
}
