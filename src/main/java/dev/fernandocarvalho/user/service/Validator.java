package dev.fernandocarvalho.user.service;

public interface Validator<T> {

    void validate(T t);
}
