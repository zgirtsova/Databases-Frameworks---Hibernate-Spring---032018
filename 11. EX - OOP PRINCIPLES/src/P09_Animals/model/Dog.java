package P09_Animals.model;

import P09_Animals.constants.Constants;

public class Dog extends Animal {

    public Dog(String name, int age, String gender, String type) {
        super(name, age, gender, type);
    }

    @Override
    public String produceSound() {
        return Constants.DOG_SOUND;
    }
}
