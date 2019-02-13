package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import test.tutorial.dragoon.springboot.learningspringboot.domain.exceptions.DomainLogicException;

@Entity
@Table(name = "user")
public class User {
    public enum Status {
        NEW,
        ACTIVE,
        DELETED,
        NOT_CONFIRMED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36, unique = true, nullable = false)
    private UUID id;
    @Column(length = 40, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String surname;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "modified_at", nullable = false)
    private LocalDateTime modifiedAt;
    @Column(length = 15, nullable = false)
    private Status status;

    public User() {
    }

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
