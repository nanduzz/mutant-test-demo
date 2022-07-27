package dev.fernandocarvalho.user.controller;

import dev.fernandocarvalho.user.controller.dto.UserDto;

import java.util.UUID;

public interface UserController {

    UserDto create(UserDto user);

    UserDto find(UUID id);
}
