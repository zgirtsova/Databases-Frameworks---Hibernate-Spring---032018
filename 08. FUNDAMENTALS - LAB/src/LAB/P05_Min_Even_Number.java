package LAB;

import java.util.*;

public class P05_Min_Even_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        List<String> doubleStr = Arrays.asList(scan.nextLine().split("\\s+"));

        OptionalDouble min = doubleStr
                .stream()
                .filter(n -> !n.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(n -> n % 2 == 0)
                .min();

        if (min.isPresent())
            System.out.printf("%.2f", min.getAsDouble());
        else
            System.out.println("No match");
    }
}
