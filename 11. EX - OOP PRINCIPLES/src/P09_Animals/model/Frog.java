package P09_Animals.model;


import P09_Animals.constants.Constants;

public class Frog extends Animal {

    public Frog(String name, int age, String gender, String type) {
        super(name, age, gender, type);
    }


    @Override
    public String produceSound() {
        return Constants.FROG_SOUND;
    }
}