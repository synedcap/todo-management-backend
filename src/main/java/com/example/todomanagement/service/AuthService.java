package com.example.todomanagement.service;

import com.example.todomanagement.dto.LoginDto;
import com.example.todomanagement.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
