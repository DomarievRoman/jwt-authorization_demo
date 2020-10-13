package com.domariev.jwtdemo.dto;

import com.domariev.jwtdemo.dto.validation.OnSignIn;
import com.domariev.jwtdemo.dto.validation.OnSignUp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    @NotBlank(groups = OnSignUp.class)
    private String firstName;
    @NotBlank(groups = OnSignUp.class)
    private String lastName;
    @Email
    @NotBlank(groups = {OnSignIn.class, OnSignUp.class})
    private String email;
    @NotBlank(groups = {OnSignIn.class, OnSignUp.class})
    private String password;
}
