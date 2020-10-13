package com.domariev.jwtdemo.mapper;

import com.domariev.jwtdemo.dto.UserDto;
import com.domariev.jwtdemo.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserDtoMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
