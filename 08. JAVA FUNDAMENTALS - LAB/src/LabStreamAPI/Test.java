package LabStreamAPI;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Sofia", "Ivanov"),
                new Person("Plovdiv", "Ivanov"),
                new Person("Plovdiv", "Zhivkov"),
                new Person("Sofia", "Marin"),
                new Person("Vidin", "Girtsov"),
                new Person("Lom", "Helder"),
                new Person("Sofia", "Petrov")
        );
        Map<String, List<String>> namesByCity = people.stream()
                .collect(groupingBy(Person::getCity,mapping(Person::getLastName, toList())));
//                .entrySet()
//                .forEach(s -> {
//                    System.out.println("Key: " + s.getKey());
//                    System.out.print("Values: ");
//                    for (int i = 0; i <s.getValue().size() ; i++) {
//                        System.out.print(s.getValue().iterator().next());
//                    }
//                    System.out.println();
//                });

    }
}
class Person {
    private String City;
    private String LastName;

    public Person(String city, String lastName) {
        City = city;
        LastName = lastName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
class City {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}