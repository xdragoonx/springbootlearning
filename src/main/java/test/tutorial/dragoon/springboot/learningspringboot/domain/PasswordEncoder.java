package test.tutorial.dragoon.springboot.learningspringboot.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    String password;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public PasswordEncoder(String password) {
        this.password = password;
    }

    public String passwordEncode() {
        return passwordEncoder.encode(password);
    }
}
