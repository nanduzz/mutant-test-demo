package dev.fernandocarvalho.user.controller.mapper.impl;

import dev.fernandocarvalho.user.controller.dto.UserDto;
import dev.fernandocarvalho.infra.mapper.SimpleMapper;
import dev.fernandocarvalho.user.models.User;

public class UserMapperImpl implements SimpleMapper<UserDto, User> {

    @Override
    public User toEntity(UserDto userDto) {
        return new User(userDto.getName(), userDto.getAge(), userDto.isActive());
    }

    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getAge(), user.isActive());
    }
}
