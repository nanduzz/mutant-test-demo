package dev.fernandocarvalho.user.repository.impl;

import dev.fernandocarvalho.user.models.User;
import dev.fernandocarvalho.infra.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements Repository<User> {

    private final Map<UUID, User> db = new HashMap<>();

    @Override
    public User save(User user) {
        db.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(UUID id) {
        if (db.containsKey(id)){
            return Optional.of(db.get(id));
        }
        return Optional.empty();
    }
}
