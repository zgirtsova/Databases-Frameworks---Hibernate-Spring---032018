package LAB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Take_Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // не ги запазваме в колекция, а само принтираме
        Arrays.stream(scanner.nextLine().split("\\s+"))

                .map(Integer::valueOf)
                .filter(n -> n >= 10 && n <= 20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n + " "));

    }
}
