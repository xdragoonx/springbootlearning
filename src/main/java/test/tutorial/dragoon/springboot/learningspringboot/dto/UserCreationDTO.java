package test.tutorial.dragoon.springboot.learningspringboot.dto;

public class UserCreationDTO {

    private String login;
    private String password;
    private String name;
    private String surname;
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
