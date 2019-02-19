package test.tutorial.dragoon.springboot.learningspringboot.domain.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import test.tutorial.dragoon.springboot.learningspringboot.domain.user.User;
import test.tutorial.dragoon.springboot.learningspringboot.domain.user.UserRepository;
import test.tutorial.dragoon.springboot.learningspringboot.dto.UserCreationDTO;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Tag("IT")
class UserCreationHandlerIT {

    @Autowired
    private UserCreationHandler handler;

    @Autowired
    private UserRepository repository;

    @Test
    @DisplayName("TBD")
    void testCreation() {
        assertTrue(true);
    }

    @Test
    @DisplayName("UserCreation")
    void userCreation() {
        UUID id = UUID.randomUUID();
        UserCreationDTO user = new UserCreationDTO("jakislogin", "jakieshaslo", "iemie", "nazwisko", "jakis@mail.com");
        handler.handle(id, user);
        assertTrue(repository.findById(id).isPresent());
    }

}
