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
            throw new NomeInvalidoException();
        }
    }

    private void validateAge(User user) {
        final int MIN_AGE = 18;
        if (user.getAge() < MIN_AGE) {
            throw new IdadeInvalidaException();
        }
    }

    static class IdadeInvalidaException extends RuntimeException {
        public IdadeInvalidaException() {
            super("Idade do usuário abaixo da minima permitida");
        }
    }

    static class NomeInvalidoException extends RuntimeException {
        public NomeInvalidoException() {
            super("None do usuário não pode ficar em branco!");
        }
    }
}
