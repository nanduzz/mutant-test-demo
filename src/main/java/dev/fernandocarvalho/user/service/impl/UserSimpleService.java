package dev.fernandocarvalho.user.service.impl;

import dev.fernandocarvalho.user.exceptions.UserNotFoundException;
import dev.fernandocarvalho.user.models.User;
import dev.fernandocarvalho.infra.Repository;
import dev.fernandocarvalho.user.service.SimpleService;
import dev.fernandocarvalho.user.service.Validator;

import java.util.Objects;
import java.util.UUID;

public class UserSimpleService implements SimpleService<User> {
    private final Repository<User> userRepository;
    private final Validator<User> userValidator;

    public UserSimpleService(Repository<User> userRepository, Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public User save(User user) {
        userValidator.validate(user);
        return userRepository.save(user);
    }

    @Override
    public User find(UUID id) {
        if (Objects.isNull(id)){
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }



}