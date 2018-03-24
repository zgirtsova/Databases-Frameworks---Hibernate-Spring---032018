package LAB.person;

public class European extends BasePerson{

    String name;
    String country;

    public European(String name) {
        super(name);
    }

    public European(String name, String country) {
        super(name);
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String sayHello() {
        return "Hello!";
    }
}
