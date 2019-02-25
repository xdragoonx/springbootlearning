package test.tutorial.dragoon.springboot.learningspringboot.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreationDTO {

    @NotNull
    @Size(min = 1, max = 40)
    private String login;
    @NotNull
    private String password;
    @NotNull
    @Size(min = 1, max = 40)
    private String name;
    @NotNull
    @Size(min = 1, max = 40)
    private String surname;
    @NotNull
    @Size(min = 1, max = 100)
    private String email;

    public UserCreationDTO(String login, String password, String name, String surname, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
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

}
