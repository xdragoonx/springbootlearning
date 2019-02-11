package test.tutorial.dragoon.springboot.learningspringboot.domain.exceptions;

public class DomainLogicException extends RuntimeException {

    public DomainLogicException(String message) {
        super(message);
    }
}
