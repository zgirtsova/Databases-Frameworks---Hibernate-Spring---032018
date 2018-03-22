package LabStreamAPI;

import java.util.*;
import java.util.stream.DoubleStream;

public class Main003DoubleStream {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        List<String> doubleStrList = Arrays.asList(scan.nextLine().split("\\s+"));

        //I ваиант: DoubleStream Има методи като average, max, min
        DoubleStream doubleStream = doubleStrList.stream().filter(n -> !n.isEmpty())
                .peek(s -> System.out.println(s))
                .mapToDouble(Double::valueOf)
                .peek(s -> System.out.println(s));

        System.out.println(doubleStream.reduce((x1, x2) -> x1 + x2).getAsDouble());
        System.out.printf("%.2f", doubleStream.average());

        //II вариант: с OptionalDouble може да ползваме isPresent
        OptionalDouble doubleStream2 = doubleStrList.stream()
                .filter(n -> !n.isEmpty()) // проверява за празен стринг
                .mapToDouble(s -> Double.parseDouble(s)).average();

        if (doubleStream2.isPresent())
            System.out.printf("%.2f", doubleStream2.getAsDouble());
        else
            System.out.println("No matches!");

    }
}
