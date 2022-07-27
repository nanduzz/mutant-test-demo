package dev.fernandocarvalho.user.repository.impl;

import dev.fernandocarvalho.user.models.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Test
    void deveSalvar(){
        User user = new User(UUID.randomUUID(), "Test", 18, true);
        User saved = userRepository.save(user);
        assertNotNull(saved);
    }

    @Test
    void deveEncontrarPorId(){
        User user = new User(UUID.randomUUID(), "Test", 18, true);
        User saved = userRepository.save(user);

        Optional<User> found = userRepository.findById(saved.getId());
        assertNotNull(found);
    }

    @Test
    void deveRetornarEmpty(){
        Optional<User> optional = userRepository.findById(UUID.randomUUID());

        assertTrue(optional.isEmpty());
    }
}