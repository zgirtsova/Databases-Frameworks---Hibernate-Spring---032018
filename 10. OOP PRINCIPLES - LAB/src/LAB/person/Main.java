package LAB.person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        BasePerson basePerson = new European("Ivan");
//        String hello = basePerson.sayHello();
//
//        System.out.println(((European)basePerson).getCountry() + ": " + hello);

        List<Person> persons = new ArrayList<>();


        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));

        for (Person p : persons) {
            print(p);
        }

    }
    private static void print(Person person) {
        System.out.println(person.sayHello());
    }

}
