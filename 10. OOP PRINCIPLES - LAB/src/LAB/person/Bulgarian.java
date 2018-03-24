package LAB.person;

public class Bulgarian extends BasePerson implements Person {

    String name;
    String town;


    public Bulgarian(String name) {
        super(name);
        //this.town = town;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello, Bulgaria!";
    }
}
