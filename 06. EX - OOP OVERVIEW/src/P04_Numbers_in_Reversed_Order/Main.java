package P04_Numbers_in_Reversed_Order;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        DecimalNumber number = new DecimalNumber(scan.nextLine());
        System.out.println(number.printReversedNumber());
    }
}
