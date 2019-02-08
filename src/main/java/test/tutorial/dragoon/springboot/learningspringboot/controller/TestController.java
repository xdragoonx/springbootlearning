package test.tutorial.dragoon.springboot.learningspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.tutorial.dragoon.springboot.learningspringboot.dto.InitDto;


@RestController
public class TestController {

    @GetMapping("/first-one")
    @ResponseStatus(HttpStatus.OK)
    public InitDto get() {
        return new InitDto(true, 1, "first string");
    }

}
