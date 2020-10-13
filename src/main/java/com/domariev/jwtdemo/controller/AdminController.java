package com.domariev.jwtdemo.controller;

import com.domariev.jwtdemo.dto.UserDto;
import com.domariev.jwtdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        log.info("Get user {}", userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
