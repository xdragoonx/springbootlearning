package test.tutorial.dragoon.springboot.learningspringboot.response;

import java.util.UUID;

public class UUIDResponse {

    private final UUID id;

    public UUIDResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
