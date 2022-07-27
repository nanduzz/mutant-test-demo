package dev.fernandocarvalho.infra;

import java.util.Optional;
import java.util.UUID;

public interface Repository<T> {

    T save(T t);

    Optional<T> findById(UUID id);

}
