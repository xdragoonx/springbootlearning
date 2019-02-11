package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.tutorial.dragoon.springboot.learningspringboot.domain.exceptions.DomainLogicException;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User testUser;

    @BeforeEach
    public void setUp(){
        testUser = new User(UUID.randomUUID(),"jakis", "ciezkiehaslo","jan","kowalski","jan@kowalski.com");
    }

    @Test
    @DisplayName("Test for changing status from NEW to ACTIVE")
    void userStatusNewActive() {
        testUser.confirmEmail();
        assertEquals(testUser.getStatus(), User.Status.ACTIVE);
    }

    @Test
    @DisplayName("Test for changing status from NEW to NOT_CONFIRMED")
    void userStatusNewNotConfirmed() {
        testUser.notConfirmedEmail();
        assertEquals(testUser.getStatus(), User.Status.NOT_CONFIRMED);
    }

    @Test
    @DisplayName("Test for changing status from ACTIVE to NOT_CONFIRMED")
    void userStatusActiveNotConfirmed() {
        testUser.confirmEmail();
        assertThrows(DomainLogicException.class,()->testUser.notConfirmedEmail());
    }
}
