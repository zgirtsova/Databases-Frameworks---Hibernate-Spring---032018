package P09_Animals;

import P09_Animals.constants.Constants;
import P09_Animals.factories.AnimalFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String command;
            while (!Constants.TERMINATE_COMMAND.equalsIgnoreCase(command = reader.readLine()) && command != null) {
                try {
                    System.out.println(AnimalFactory
                            .getInstance()
                            .produceAnimal(command, reader.readLine().trim().split(Constants.TOKENS_SEPARATOR))
                            .getInfo());
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
