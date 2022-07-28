package dev.fernandocarvalho.user.service.impl;

import dev.fernandocarvalho.user.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    UserValidator validator = new UserValidator();

    @Test
    void deveLancarIdadeInvalidaException(){
        assertThrows(
                UserValidator.IdadeInvalidaException.class,
                () -> validator.validate(new User("Teste", 17, true))
        );
    }

    @Test
    void deveLancarNomeInvalidoException(){
        assertThrows(
                UserValidator.NomeInvalidoException.class,
                () -> validator.validate(new User("", 18, true))
        );
    }

    @Test
    void naoDeveLancarExceptionQuandoValidacoesEstiveremCorretas(){
        try{
            validator.validate(new User("teste", 18, true));
        }catch (RuntimeException e ){
            Assertions.fail();
        }
    }

}