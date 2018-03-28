package P06_Birthday_Celebrations.model;

import P06_Birthday_Celebrations.contracts.Birthable;
import P06_Birthday_Celebrations.contracts.Nameable;

public class Pet implements Nameable, Birthable {

    private final String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
