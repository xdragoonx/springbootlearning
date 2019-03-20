package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;

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
    @Column(length = 16, updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(length = 40, nullable = false, unique = true)
    private String login;
    @Column(length = 60, nullable = false)
    private String password;
    @Embedded
    private UserData userData;
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
        this.userData = new UserData(name, surname, email);
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

    public void setUserData(String name, String surname, String email) {
        this.userData = new UserData(name, surname, email);
    }

    public String getName() {
        return userData.getName();
    }

    public String getSurname() {
        return userData.getSurname();
    }

    public String getEmail() {
        return userData.getEmail();
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
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id)
                && login.equals(user.login)
                && password.equals(user.password)
                && userData.equals(user.userData)
                && createdAt.equals(user.createdAt)
                && modifiedAt.equals(user.modifiedAt)
                && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, userData, createdAt, modifiedAt, status);
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
