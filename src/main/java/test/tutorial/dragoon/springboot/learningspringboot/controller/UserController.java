package test.tutorial.dragoon.springboot.learningspringboot.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.tutorial.dragoon.springboot.learningspringboot.domain.handler.UserCreationHandler;
import test.tutorial.dragoon.springboot.learningspringboot.dto.UserCreationDTO;
import test.tutorial.dragoon.springboot.learningspringboot.response.UUIDResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserCreationHandler handler;

    @Autowired
    public UserController(UserCreationHandler handler) {
        this.handler = handler;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UUIDResponse create(@Validated @RequestBody UserCreationDTO requestUser) {
        UUID id = UUID.randomUUID();
        handler.handle(id, requestUser);
        return new UUIDResponse(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UUIDResponse createOrEdit(@PathVariable UUID id, @Validated @RequestBody UserCreationDTO requestUser) {
        handler.handle(id, requestUser);
        return new UUIDResponse(id);
    }

}
