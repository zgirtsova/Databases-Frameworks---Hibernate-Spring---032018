package entities;

import java.time.LocalDate;

public class Teacher {

    private int id;
    private String first_name;
    private LocalDate birthday;

    public Teacher() {
    }

    public Teacher(String first_name, LocalDate birthday) {
        this.first_name = first_name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
