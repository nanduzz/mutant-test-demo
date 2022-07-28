package dev.fernandocarvalho.user.controller.dto;

import dev.fernandocarvalho.user.models.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    @Test
    void deveCriarUsuarioAtivoSemId() {
        UUID id = UUID.randomUUID();
        UserDto user = new UserDto(id, "Test", 45, true);
        assertAll(
                () -> assertEquals(id, user.getId()),
                () -> assertEquals("Test", user.getName()),
                () -> assertEquals(45, user.getAge()),
                () -> assertTrue(user.isActive())
        );
    }

    @Test
    void deveCriarUsuarioInativoSemId(){
        UUID id = UUID.randomUUID();
        UserDto user = new UserDto(id, "Test", 45, false);
        assertAll(
                () -> assertEquals(id, user.getId()),
                () -> assertEquals("Test", user.getName()),
                () -> assertEquals(45, user.getAge()),
                () -> assertFalse(user.isActive())
        );
    }

}