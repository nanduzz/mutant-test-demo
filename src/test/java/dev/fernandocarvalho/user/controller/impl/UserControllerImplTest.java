package dev.fernandocarvalho.user.controller.impl;

import dev.fernandocarvalho.user.controller.dto.UserDto;
import dev.fernandocarvalho.user.controller.mapper.impl.UserMapperImpl;
import dev.fernandocarvalho.user.models.User;
import dev.fernandocarvalho.user.repository.impl.UserRepositoryImpl;
import dev.fernandocarvalho.user.service.impl.UserSimpleService;
import dev.fernandocarvalho.user.service.impl.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerImplTest {

    private UserControllerImpl userController;
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp(){
        userRepository = new UserRepositoryImpl();
        UserSimpleService service = new UserSimpleService(userRepository, new UserValidator());

        UserMapperImpl mapper = new UserMapperImpl();
        userController = new UserControllerImpl(mapper, service);
    }

    @Test
    void deveSalvar(){
        UserDto dto = new UserDto("Test", 32, true);
        UserDto saved = userController.create(dto);

        assertNotNull(saved);
    }

    @Test
    void deveEncontrar(){
        UUID id = UUID.randomUUID();
        userRepository.save(new User(id, "test", 32, true));

        UserDto found = userController.find(id);
        assertNotNull(found);
        assertEquals(id, found.getId());
    }

}