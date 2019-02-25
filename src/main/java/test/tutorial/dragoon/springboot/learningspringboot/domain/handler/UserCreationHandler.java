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

    @Autowired
    public UserCreationHandler(UserRepository repository) {
        this.repository = repository;
    }

    public void handle(UUID id, UserCreationDTO dto) {
        PasswordEncoder password = new PasswordEncoder(dto.getPassword());
        User user = new User(id, dto.getLogin(), password.passwordEncode(), dto.getName(), dto.getSurname(),
                dto.getEmail());
        repository.save(user);
    }
}
