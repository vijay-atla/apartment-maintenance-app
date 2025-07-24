package com.apartment.maintenance.service.interfaces;

import com.apartment.maintenance.dto.LoginRequestDTO;
import com.apartment.maintenance.dto.RegisterRequestDTO;
import com.apartment.maintenance.entity.User;

public interface UserService {
    User registerAdmin(RegisterRequestDTO request);

    User loginResidencyAdmin(LoginRequestDTO request);
}
