package LabStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main001UpperCase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        List<String> names = Arrays.asList(scan.nextLine().split(" "));

        Stream<String> namesStream = names.stream();
        namesStream.map(String::toUpperCase)
                .peek(s -> System.out.println(s + " "))
                .map(s -> s.toLowerCase())
                .forEach(s -> System.out.println(s + " "));

    }
}
