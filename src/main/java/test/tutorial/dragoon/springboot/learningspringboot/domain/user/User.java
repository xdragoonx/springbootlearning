package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import java.time.LocalDateTime;
import java.util.UUID;

import test.tutorial.dragoon.springboot.learningspringboot.domain.exceptions.DomainLogicException;

public class User {
    public enum Status {
        NEW,
        ACTIVE,
        DELETED,
        NOT_CONFIRMED
    }

    private final UUID id;
    private final String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private final LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Status status;


    public User(UUID id, String login, String password, String name, String surname, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.status = status.NEW;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public Status getStatus() {
        return status;
    }

    private boolean isReadyToOutDate() {
        return status.equals(Status.NEW);
    }

    public void confirmEmail() {
        status = Status.ACTIVE;
        modifiedAt = LocalDateTime.now();
    }

    public void notConfirmedEmail() {
        if (!isReadyToOutDate()) {
            throw new DomainLogicException("You can't change status to " + Status.NOT_CONFIRMED + ", because of "
                    + "current status: " + status + ", for user " + id);
        }
        status = Status.NOT_CONFIRMED;
        modifiedAt = LocalDateTime.now();
    }

    public void deleteUser() {
        status = Status.DELETED;
        modifiedAt = LocalDateTime.now();
    }

}
