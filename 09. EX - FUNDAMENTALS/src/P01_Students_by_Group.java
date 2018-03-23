import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class P01_Students_by_Group {
    public static void main(String[] args) {

        List<String> input = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line;

            while (!"END".equalsIgnoreCase(line = reader.readLine().trim())) {
                input.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        input.stream()
            .map(str -> str.split("\\s+"))
            .filter(student -> student[2].equals("2"))
            .sorted(Comparator.comparing(student -> student[0]))
            .forEach(student -> System.out.printf("%s %s%n", student[0], student[1]));
    }
}
