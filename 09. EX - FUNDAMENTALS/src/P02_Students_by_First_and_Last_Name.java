import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class P02_Students_by_First_and_Last_Name {
    public static void main(String[] args) throws IOException {

        List<String> input = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (!"END".equalsIgnoreCase(line = reader.readLine().trim())) {
                input.add(line);
            }

        input.stream()
            .map(str -> str.split("\\s+"))
            .filter(student -> student[0].compareTo(student[1]) < 0)
            .forEach(student -> System.out.printf("%s %s%n", student[0], student[1]));
    }
}
