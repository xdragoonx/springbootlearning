package test.tutorial.dragoon.springboot.learningspringboot.domain;

public abstract class DomainLogicException extends RuntimeException {

    public DomainLogicException(String message) {
        super(message);
    }
}
