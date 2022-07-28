package dev.fernandocarvalho.user.controller.dto;

import java.util.UUID;

public class UserDto {

    private UUID id;
    private final String name;
    private final int age;
    private final boolean active;

    public UserDto(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public UserDto(UUID id, String name, int age, boolean active) {
        this(name, age, active);
        this.id = id;
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
