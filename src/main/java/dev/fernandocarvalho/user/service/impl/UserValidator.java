package dev.fernandocarvalho.user.service.impl;

import dev.fernandocarvalho.user.models.User;
import dev.fernandocarvalho.user.service.Validator;

public class UserValidator implements Validator<User> {

    private final int MIN_AGE = 18;

    @Override
    public void validate(User user) {
        if (user.getAge() < MIN_AGE) {
            throw new RuntimeException("Idade do usuário abaixo da minima permitida");
        }

        if (user.getName().isBlank()) {
            throw new RuntimeException("None do usuário não pode ficar em branco!");
        }
    }
}
