package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.Email;

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
    @Column(length = 36, unique = true, nullable = false)
    private UUID id;
    @Column(length = 40, nullable = false, unique = true)
    private String login;
    @Column(length = 60, nullable = false)
    private String password;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String surname;
    @Column(length = 100, nullable = false, unique = true)
    @Email
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id)
                && login.equals(user.login)
                && password.equals(user.password)
                && name.equals(user.name)
                && surname.equals(user.surname)
                && email.equals(user.email)
                && createdAt.equals(user.createdAt)
                && modifiedAt.equals(user.modifiedAt)
                && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, surname, email, createdAt, modifiedAt, status);
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
            throw new UserDomainLogicException("You can't change status to " + Status.NOT_CONFIRMED + ", because of "
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
