package main.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    SUBSIDIZED, SPORTSMAN, ORDINARY;

    public static Optional<Role> find(String role) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}
