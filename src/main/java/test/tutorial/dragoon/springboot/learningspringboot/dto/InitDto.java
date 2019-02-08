package test.tutorial.dragoon.springboot.learningspringboot.dto;

public class InitDto {

    private final boolean tutorial;
    private final Integer number;
    private final String text;

    public InitDto(boolean tutorial, Integer number, String text) {
        this.tutorial = tutorial;
        this.number = number;
        this.text = text;
    }

    public boolean isTutorial() {
        return tutorial;
    }

    public Integer getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}
