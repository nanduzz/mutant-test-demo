package dev.fernandocarvalho.user.service.impl;

import dev.fernandocarvalho.user.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    UserValidator validator = new UserValidator();

    @Test
    void deveLancarRuntimeExceptionQuandoIdadeInvalida(){
        assertThrows(
                RuntimeException.class,
                () -> validator.validate(new User("Teste", 15, true))
        );
    }

    @Test
    void deveLancarRuntimeExceptionQuandoNomeEmBranco(){
        assertThrows(
                RuntimeException.class,
                () -> validator.validate(new User("", 33, true))
        );
    }

    @Test
    void deveValidarUsuarioCorretamente(){
        try {
            validator.validate(new User("Teste", 33, true));
        }catch (RuntimeException e){
            Assertions.fail();
        }
    }

}