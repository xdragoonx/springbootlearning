package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import test.tutorial.dragoon.springboot.learningspringboot.domain.DomainLogicException;

public class UserDomainLogicException extends DomainLogicException {

    public UserDomainLogicException(String message) {
        super(message);
    }
}
