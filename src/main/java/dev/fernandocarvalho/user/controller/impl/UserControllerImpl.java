package dev.fernandocarvalho.user.controller.impl;

import dev.fernandocarvalho.user.controller.UserController;
import dev.fernandocarvalho.infra.mapper.SimpleMapper;
import dev.fernandocarvalho.user.models.User;
import dev.fernandocarvalho.user.controller.dto.UserDto;
import dev.fernandocarvalho.user.service.SimpleService;

import java.util.UUID;

public class UserControllerImpl implements UserController {

    private final SimpleMapper<UserDto, User> userMapper;
    private final SimpleService<User> userSimpleService;

    public UserControllerImpl(SimpleMapper<UserDto, User> userMapper,
                              SimpleService<User> userSimpleService) {
        this.userMapper = userMapper;
        this.userSimpleService = userSimpleService;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User userSaved = userSimpleService.save(user);
        return userMapper.toDto(userSaved);
    }

    @Override
    public UserDto find(UUID id) {
        User userFound = userSimpleService.find(id);
        return userMapper.toDto(userFound);
    }
}
