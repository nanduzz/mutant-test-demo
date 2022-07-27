package dev.fernandocarvalho.user.service.impl;

import dev.fernandocarvalho.user.models.User;
import dev.fernandocarvalho.user.service.Validator;

public class UserValidator implements Validator<User> {

    @Override
    public void validate(User user) {
        validateAge(user);
        validateName(user);
    }

    private void validateName(User user) {
        if (user.getName().isBlank()) {
            throw new RuntimeException("None do usuário não pode ficar em branco!");
        }
    }

    private void validateAge(User user) {
        final int MIN_AGE = 18;
        if (user.getAge() < MIN_AGE) {
            throw new RuntimeException("Idade do usuário abaixo da minima permitida");
        }
    }
}
