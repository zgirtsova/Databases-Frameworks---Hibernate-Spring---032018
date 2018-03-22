package LabStreamAPI;

import java.util.*;

public class Main005SumInt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        List<String> intStr = Arrays.asList(scan.nextLine().split("\\s+"));

        OptionalInt sum = intStr
                .stream()
                .filter(n -> !n.isEmpty())
                .filter(n -> isInt(n))
                .filter(n -> n.matches("-?\\d+"))
                .peek(n -> System.out.println(n))
                .mapToInt(Integer::valueOf)
                .reduce(Integer::sum);
//              .reduce((x1, x2) -> x1 + x2); - еднакво с горното
//              .sum();

        if (sum.isPresent())
            System.out.printf("%.2f", sum.getAsInt());
        else
            System.out.println("No matches!");

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
            e.printStackTrace();
            return false;
        }
        finally
        {
            return false;
        }
    }
}