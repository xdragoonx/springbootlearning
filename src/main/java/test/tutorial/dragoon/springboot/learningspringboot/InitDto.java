package test.tutorial.dragoon.springboot.learningspringboot;

public class InitDto {

    private boolean tutorial;
    private Integer number;
    private String text;

    public InitDto() {
    }

    public InitDto(boolean tutorial, Integer number, String text) {
        this.tutorial = tutorial;
        this.number = number;
        this.text = text;
    }

    public boolean isTutorial() {
        return tutorial;
    }

    public void setTutorial(boolean tutorial) {
        this.tutorial = tutorial;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
