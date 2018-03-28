package P05_Border_Control.model;

public class Citizen extends AbstractIdentable {

    private final String name;
    private int age;

    public Citizen(String id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }
}
