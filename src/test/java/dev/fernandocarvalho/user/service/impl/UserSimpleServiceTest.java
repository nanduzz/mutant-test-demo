package dev.fernandocarvalho.user.service.impl;

import dev.fernandocarvalho.user.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserSimpleServiceTest {

    @Test
    void deveLancarRuntimeExceptionQuandoUsuarioNaoExiste() {
        UserSimpleService service = new UserSimpleService(new UserRepositoryImpl(), new UserValidator());

        assertThrows(
                RuntimeException.class,
                () -> service.find(UUID.randomUUID())
        );
    }

}