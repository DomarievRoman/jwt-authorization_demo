package com.domariev.jwtdemo.service;

import com.domariev.jwtdemo.dto.AuthenticationRequestDto;
import com.domariev.jwtdemo.dto.UserDto;

public interface AuthenticationService {

    UserDto signUp(UserDto userDto);

    AuthenticationRequestDto signIn(AuthenticationRequestDto requestDto);
}
