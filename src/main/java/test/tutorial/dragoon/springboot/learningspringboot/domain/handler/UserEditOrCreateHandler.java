package test.tutorial.dragoon.springboot.learningspringboot.domain.handler;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.tutorial.dragoon.springboot.learningspringboot.domain.PasswordEncoder;
import test.tutorial.dragoon.springboot.learningspringboot.domain.user.User;
import test.tutorial.dragoon.springboot.learningspringboot.domain.user.UserRepository;
import test.tutorial.dragoon.springboot.learningspringboot.dto.UserCreationDTO;

@Service
public class UserEditOrCreateHandler {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserCreationHandler userCreationHandler;

    @Autowired
    public UserEditOrCreateHandler(UserRepository repository, PasswordEncoder passwordEncoder,
                                   UserCreationHandler userCreationHandler) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.userCreationHandler = userCreationHandler;
    }

    public void handle(UUID id, UserCreationDTO dto) {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            user.get().setUserData(dto.getName(), dto.getSurname(), dto.getEmail());
            repository.save(user.get());
        } else {
            userCreationHandler.handle(id, dto);
        }
    }

}
