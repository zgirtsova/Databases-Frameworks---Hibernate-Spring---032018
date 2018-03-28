package P08_Vehicles;

import P08_Vehicles.model.Car;
import P08_Vehicles.model.Truck;
import P08_Vehicles.model.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            Car car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

            tokens = reader.readLine().trim().split("\\s+");
            Truck truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

            int commands = Integer.parseInt(reader.readLine());
            while (commands-- > 0) {
                tokens = reader.readLine().trim().split("\\s+");

                if (tokens.length != 3) {
                    continue;
                }

                String command = tokens[0].toLowerCase();
                String target = tokens[1].toLowerCase();
                double value = Double.parseDouble(tokens[2]);

                Vehicle vehicle;

                switch (target) {
                    case "car":
                        target = "Car";
                        vehicle = car;
                        break;
                    case "truck":
                        target = "Truck";
                        vehicle = truck;
                        break;
                    default:
                        continue;
                }

                try {
                    switch (command) {
                        case "drive":
                            vehicle.drive(value);
                            System.out.printf("%s travelled %s km%n", target,
                                    new DecimalFormat("#.##################").format(value));
                            break;
                        case "refuel":
                            vehicle.refuel(value);
                            break;
                        default:
                            break;
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
            System.out.printf("Car: %.2f%n", car.getFuelQuantity());
            System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
