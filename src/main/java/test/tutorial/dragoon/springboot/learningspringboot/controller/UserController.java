package test.tutorial.dragoon.springboot.learningspringboot.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.tutorial.dragoon.springboot.learningspringboot.domain.handler.UserCreationHandler;
import test.tutorial.dragoon.springboot.learningspringboot.dto.UserCreationDTO;

@RestController
public class UserController {

    @Autowired
    UserCreationHandler handler;

    @PostMapping(path = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, Object> create(@Validated @RequestBody UserCreationDTO requestUser) {
        HashMap<String, Object> jsonObject = new HashMap<>();
        UUID id = UUID.randomUUID();

        handler.handle(id, requestUser);
        jsonObject.put("userId", id);

        return jsonObject;
    }

    @PutMapping(path = "/users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrEdit(@PathVariable UUID userId, @Validated @RequestBody UserCreationDTO requestUser) {
        handler.handle(userId, requestUser);
    }

}
