package test.tutorial.dragoon.springboot.learningspringboot.domain.user;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;


@Embeddable
public class UserData {

    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String surname;
    @Column(length = 100, nullable = false, unique = true)
    @Email
    private String email;

    public UserData() {
    }

    public UserData(String name, String surname, @Email String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserData)) {
            return false;
        }
        UserData userData = (UserData) o;
        return name.equals(userData.name)
                && surname.equals(userData.surname)
                && email.equals(userData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email);
    }
}
