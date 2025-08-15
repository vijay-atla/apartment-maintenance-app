package com.apartment.maintenance.user.service;

import com.apartment.maintenance.auth.dto.LoginRequestDTO;
import com.apartment.maintenance.auth.dto.RegisterRequestDTO;
import com.apartment.maintenance.user.entity.User;

public interface UserService {
    User registerAdmin(RegisterRequestDTO request);

    User loginResidencyAdmin(LoginRequestDTO request);
}
