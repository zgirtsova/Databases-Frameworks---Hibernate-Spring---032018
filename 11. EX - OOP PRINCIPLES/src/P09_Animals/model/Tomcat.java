package P09_Animals.model;

import P09_Animals.constants.Constants;

public class Tomcat extends Cat {

    public Tomcat(String name, int age, String gender, String type) {
        super(name, age, gender, type);
    }

    @Override
    public String produceSound() {
        return Constants.TOMCAT_SOUND;
    }
}