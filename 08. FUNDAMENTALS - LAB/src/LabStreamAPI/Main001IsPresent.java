package LabStreamAPI;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Stream;

public class Main001IsPresent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        List<String> names = Arrays.asList(scan.nextLine().split(" "));

        Character ch = scan.nextLine().toLowerCase().charAt(0);

        // findFirst е терминираща операция и връща Optional<String>,
        // а first.isPresent проверява дали има такъв елемент, за да не изгърми
        // или да хвърли exception
        Optional<String> first = names
                .stream()
                .filter(name -> ch == name.toLowerCase().charAt(0))
                .sorted()
                .findFirst();

        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("No matches!");
        }

    }
}
