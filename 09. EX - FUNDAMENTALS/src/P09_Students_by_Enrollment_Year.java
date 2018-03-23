import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P09_Students_by_Enrollment_Year {
    public static void main(String[] args) throws IOException {

        streamOfInputData()
                .filter(student -> student[0].endsWith("14") || student[0].endsWith("15"))
                .forEach(student -> System.out.println(String.join(" ", Arrays.stream(student).skip(1).collect(Collectors.toList()))));
    }


    private static Stream<String[]> streamOfInputData() throws IOException {
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