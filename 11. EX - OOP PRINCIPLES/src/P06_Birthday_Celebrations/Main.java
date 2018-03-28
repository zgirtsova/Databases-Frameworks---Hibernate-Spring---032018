package P06_Birthday_Celebrations;

import P06_Birthday_Celebrations.contracts.Birthable;
import P06_Birthday_Celebrations.contracts.Identable;
import P06_Birthday_Celebrations.model.Citizen;
import P06_Birthday_Celebrations.model.Pet;
import P06_Birthday_Celebrations.model.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Birthable> birthables = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line;

            while (!"End".equalsIgnoreCase(line = reader.readLine().trim())) {
                String[] tokens = line.split("\\s+");

                String type = tokens[0];

                if ("Pet".equalsIgnoreCase(type)) {
                    String name = tokens[1];
                    String birthday = tokens[2];
                    birthables.add(new Pet(name, birthday));
                } else if ("Citizen".equalsIgnoreCase(type)) {
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthday = tokens[4];
                    birthables.add(new Citizen(id, name, age, birthday));
                }
            }

            String year = reader.readLine().trim();

            birthables.stream()
                    .filter(birthable -> birthable.getBirthday().endsWith(year))
                    .forEach(birthable -> System.out.println(birthable.getBirthday()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
