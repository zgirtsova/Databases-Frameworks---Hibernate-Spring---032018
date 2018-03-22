package LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class P02_Upper_Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        List<String> names = Arrays.asList(scan.nextLine().split(" "));

        Stream<String> namesStream = names.stream();

        namesStream.map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

    }
}
