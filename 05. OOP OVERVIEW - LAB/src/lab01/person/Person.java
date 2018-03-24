package lab01.person;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<BankAccount> accounts;

    Person(String name,int age){
        this.name = name;
        this.age = age;
        this.accounts = new ArrayList<>();
    }
    Person(String name, int age, List<BankAccount> accs) {
        this.name = name;
        this.age = age;
        this.accounts = accs;
    }

    @Override
    public String toString() {
        String personAccounts = "";
        for (BankAccount account: this.accounts) {
            personAccounts = personAccounts + "; "
            + String.format("%s ", account.toString());
        }
        String personInfo = String.format("Name: %s, age: %d",
                this.name, this.age);
        return personInfo + " " + personAccounts;
    }
    public void getPersonsAccounts(){
        System.out.println(
                "The current interest rate is: "
                        + BankAccount.getInterestRate());
        this.accounts.forEach(System.out::println);
    }
}
