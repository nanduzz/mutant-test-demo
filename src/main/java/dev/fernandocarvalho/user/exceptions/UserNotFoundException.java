package dev.fernandocarvalho.user.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("Usuario não encontrado!!");
    }
}
