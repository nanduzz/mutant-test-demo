package dev.fernandocarvalho.user.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void deveCriarUsuarioAtivoSemId() {
        User user = new User("Test", 45, true);
        assertAll(
                () -> assertEquals("Test", user.getName()),
                () -> assertEquals(45, user.getAge()),
                () -> assertTrue(user.isActive())
        );
    }

    @Test
    void deveCriarUsuarioInativoSemId(){
        User user = new User("Test", 45, false);
        assertAll(
                () -> assertEquals("Test", user.getName()),
                () -> assertEquals(45, user.getAge()),
                () -> assertFalse(user.isActive())
        );
    }

}