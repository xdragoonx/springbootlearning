package test.tutorial.dragoon.springboot.learningspringboot.domain.handler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.tutorial.dragoon.springboot.learningspringboot.domain.PasswordEncoder;
import test.tutorial.dragoon.springboot.learningspringboot.domain.user.User;
import test.tutorial.dragoon.springboot.learningspringboot.domain.user.UserRepository;
import test.tutorial.dragoon.springboot.learningspringboot.dto.UserCreationDTO;

@Service
public class UserCreationHandler {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserCreationHandler(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void handle(UUID id, UserCreationDTO dto) {
        User user = new User(id, dto.getLogin(), passwordEncoder.encode(dto.getPassword()), dto.getName(),
                dto.getSurname(), dto.getEmail());
        repository.save(user);
    }
}
