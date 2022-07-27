package dev.fernandocarvalho.user.models;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String name;
    private final int age;
    private final boolean active;

    public User(String name, int age, boolean active) {
        this(UUID.randomUUID(), name, age, active);
    }

    public User(UUID id, String name, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }
}
