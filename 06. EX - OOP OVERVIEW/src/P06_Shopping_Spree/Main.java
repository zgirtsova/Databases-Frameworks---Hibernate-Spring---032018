package P06_Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            boolean mustBrake = false;
            String[] peopleLine = reader.readLine().split(";");
            String[] productLine = reader.readLine().split(";");
            Set<Person> personsSet = new LinkedHashSet<>();
            Set<Product> productsSet = new LinkedHashSet<>();

            readPerson(peopleLine, personsSet);
            readProducts(productLine, productsSet);

            String command = reader.readLine();

            while (!command.equals("END")) {
                String nameInput = command.split(" ")[0];
                String productInput = command.split(" ")[1];

                for (Person p : personsSet) {
                    if (p.getName().equals(nameInput)) {
                        for (Product pr : productsSet) {
                            if (pr.getProduct().equals(productInput)) {
                                p.addToBag(pr.getProduct(), pr.getPrice());
                            }
                        }
                    }
                }
                try {
                    command = reader.readLine();
                    //защото в judge липсва END на някои от тестовете
                    if (command.isEmpty()) break;
                } catch (Exception e) {
                    break;
                }
            }
            for (Person person : personsSet) {
                person.getPurchases();
            }

        } catch(Exception ex) {
            System.out.println(ex.getMessage());

            return;
        }
    }

    private static void readProducts(String[] productLine, Set<Product> productsSet) {
        for (int i = 0; i < productLine.length; i++) {
            String product = productLine[i].split("=")[0];
            int price = Integer.parseInt(productLine[i].split("=")[1]);
            productsSet.add(new Product(product, price));
        }
    }

    private static void readPerson(String[] peopleLine, Set<Person> personsSet) {
        for (int i = 0; i < peopleLine.length; i++) {
            String name = peopleLine[i].split("=")[0];
            int money = Integer.parseInt(peopleLine[i].split("=")[1]);
            personsSet.add(new Person(name, money));
        }
    }
}
