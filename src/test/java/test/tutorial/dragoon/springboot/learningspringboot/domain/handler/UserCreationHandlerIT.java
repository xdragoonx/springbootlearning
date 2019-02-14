package test.tutorial.dragoon.springboot.learningspringboot.domain.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Tag("IT")
class UserCreationHandlerIT {

    @Autowired
    private UserCreationHandler handler;

    @Test
    @DisplayName("TBD")
    void testCreation() {
        assertTrue(true);
    }

}