import P06_Shopping_Spree.Person;
import P06_Shopping_Spree.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Mainnnnnn {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] peopleLine = reader.readLine().split(";");
        String[] productLine = reader.readLine().split(";");
        Set<Person> personsSet = new LinkedHashSet<>();
        Set<Product> productsSet = new LinkedHashSet<>();

        for (int i = 0; i < peopleLine.length; i++) {
            String name = peopleLine[i].split("=")[0];
            int money = Integer.parseInt(peopleLine[i].split("=")[1]);
            personsSet.add(new Person(name, money));
        }
        for (int i = 0; i < productLine.length; i++) {
            String product = productLine[i].split("=")[0];
            int price = Integer.parseInt(peopleLine[i].split("=")[1]);
            productsSet.add(new Product(product, price));
        }
    }
}
