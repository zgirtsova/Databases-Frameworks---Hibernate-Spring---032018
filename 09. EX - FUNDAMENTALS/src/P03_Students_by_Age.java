import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class P03_Students_by_Age {
    public static void main(String[] args) {

        streamOfInputData()
                .filter(student -> {
                    int age = Integer.parseInt(student[2]);
                    return age >= 18 && age <= 24;
                })
                .forEach(student -> System.out.println(String.join(" ", student)));
    }

    private static Stream<String[]> streamOfInputData() {
        List<String> input = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line;

            while (!"END".equalsIgnoreCase(line = reader.readLine().trim())) {
                input.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input.stream().map(str -> str.split("\\s+"));
    }
}