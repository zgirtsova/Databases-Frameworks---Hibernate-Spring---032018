package P03_Last_Digit_Name;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        int n = Integer.parseInt(scan.nextLine());
        Number nu = new Number(n);
        System.out.println(nu.returnEnglishName());
    }
}

