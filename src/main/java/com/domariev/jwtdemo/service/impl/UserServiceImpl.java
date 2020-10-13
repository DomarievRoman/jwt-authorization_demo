package com.domariev.jwtdemo.service.impl;

import com.domariev.jwtdemo.dto.UserDto;
import com.domariev.jwtdemo.mapper.UserDtoMapper;
import com.domariev.jwtdemo.model.User;
import com.domariev.jwtdemo.repository.UserRepository;
import com.domariev.jwtdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private UserDtoMapper mapper = Mappers.getMapper(UserDtoMapper.class);

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        log.info("getAll() - {} users found", users.size());
        return users;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        log.info("findByEmail() - user: {} found by username: {}", user, email);
        return user;
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        log.info("findById() - user: {} found by id: {}", user, id);
        return mapper.userToUserDto(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("delete() - user with id: {} deleted", id);
    }
}
