package test.tutorial.dragoon.springboot.learningspringboot.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public final class PasswordEncoderBCrypt implements PasswordEncoder {

    @Override
    public final String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
