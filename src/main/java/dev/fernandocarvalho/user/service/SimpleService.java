package dev.fernandocarvalho.user.service;

import java.util.UUID;

public interface SimpleService<T> {

    T save(T t);

    T find(UUID id);
}
