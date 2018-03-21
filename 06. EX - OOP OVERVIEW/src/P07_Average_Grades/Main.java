package P07_Average_Grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> students = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        // reading Students from console
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0];
            double[] grades = new double[input.length - 1];
            for (int j = 1; j < input.length; j++) {
                grades[j - 1] = (Double.parseDouble(input[j]));
            }
            students.add(new Student(name, grades));
        }

        students.stream()
                .filter(s -> s.getAverage() >= 5.00)
                // СОРТИРАНЕ ПЪРВО ПО ИМЕ, ПОСЛЕ ПО СРЕДНА ОЦЕНКА
                .sorted((a, b) -> {
                    int result = a.getName().compareTo(b.getName());

                    if (result == 0) {
                        result = Double.compare(b.getAverage(), a.getAverage());
                    }

                    return result;
                })
                .forEach(s -> {
                    System.out.printf("%s -> %.2f%n", s.getName(), s.getAverage());
                }
         );
    }
}
