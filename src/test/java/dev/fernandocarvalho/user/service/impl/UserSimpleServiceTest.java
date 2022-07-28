package dev.fernandocarvalho.user.service.impl;

import dev.fernandocarvalho.user.models.User;
import dev.fernandocarvalho.user.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserSimpleServiceTest {

    private final UserValidator userValidator = Mockito.mock(UserValidator.class);
    private final UserSimpleService service = new UserSimpleService(new UserRepositoryImpl(), userValidator);

    @Test
    void deveLancarRuntimeExceptionQuandoUsuarioNaoExiste() {
        assertThrows(
                RuntimeException.class,
                () -> service.find(UUID.randomUUID())
        );
    }

    @Test
    void deveLancarIllegalArgumentExceptionQuandoPesquisaPorIdNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.find(null)
        );
    }

    @Test
    void deveValidarUsuarioAntesDeCriar() {
        User testUser = new User("Test", 18, true);

        service.save(testUser);
        Mockito.verify(userValidator, Mockito.times(1))
                .validate(testUser);

    }

}