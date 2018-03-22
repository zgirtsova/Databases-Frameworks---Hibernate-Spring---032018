package LAB;

import java.util.*;

public class P06_Find_and_Sum_Integers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        List<String> intStr = Arrays.asList(scan.nextLine().split("\\s+"));

        OptionalInt sum = intStr
                .stream()
                .filter(n -> !n.isEmpty())
                //.filter(n -> isInt(n)) // долният ред върши същото
                .filter(n -> n.matches("-?\\d+"))
                .mapToInt(Integer::valueOf)
                .reduce(Integer::sum);
//              .reduce((x1, x2) -> x1 + x2); - еднакво с горното
//              .sum();

        if (sum.isPresent())
            System.out.printf("%d", sum.getAsInt());
        else
            System.out.println("No match");

    }
    static boolean isInt(String s) {
        try
        {
            int i = Integer.parseInt(s); return true;
        }
        catch (NumberFormatException er)
        {
            return false;
        }
        catch (NullPointerException e)
        {
            return false;
        }
    }
}
