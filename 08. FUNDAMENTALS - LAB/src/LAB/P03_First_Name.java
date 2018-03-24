package LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P03_First_Name {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stream<String> namesStream = Arrays.stream(reader.readLine().split("\\s+"));

            // чете нова колекция от конзолата от chars
            HashSet<Character> chars = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(s -> s.toUpperCase().charAt(0))
                    .collect(Collectors.toCollection(HashSet::new));

            System.out.println(namesStream
                    .filter(name -> chars.contains(name.toUpperCase().charAt(0)))
                    .findFirst() //част от OptionalStream
                    .orElse("No match")); // също част от OptionalStream,
                                                // връща default стойност, ако няма друго
    }
}
