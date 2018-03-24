package LAB.person;

public class Chinese extends BasePerson{

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello, China!";
    }
}
