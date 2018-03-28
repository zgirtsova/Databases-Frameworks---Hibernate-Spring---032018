package P06_Birthday_Celebrations.model;

import P06_Birthday_Celebrations.contracts.Birthable;
import P06_Birthday_Celebrations.contracts.Nameable;

public class Citizen extends AbstractIdentable implements Birthable, Nameable {

    private final String name;
    private int age;
    private String birthday;

    public Citizen(String id, String name, int age, String birthday) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
