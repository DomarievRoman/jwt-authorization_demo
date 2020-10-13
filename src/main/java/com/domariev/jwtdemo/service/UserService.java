package com.domariev.jwtdemo.service;

import com.domariev.jwtdemo.dto.UserDto;
import com.domariev.jwtdemo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findByEmail(String email);

    UserDto findById(Long id);

    void delete(Long id);

}
