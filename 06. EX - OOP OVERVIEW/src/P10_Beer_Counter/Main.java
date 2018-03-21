package P10_Beer_Counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String command = reader.readLine();
            while (!"End".equals(command)) {
                if (!command.isEmpty()) {
                    String[] beer = command.split("\\s+");
                    int beerBought = Integer.parseInt(beer[0]);
                    int beerDrank = Integer.parseInt(beer[1]);

                    BeerCounter.BuyBeer(beerBought);
                    BeerCounter.DrinkBeer(beerDrank);
                }

                command = reader.readLine();
            }
        } catch (Exception _ignored) {

        } finally {
            System.out.printf("%d %d%n", BeerCounter.getBeerInStock(), BeerCounter.getBeerDrankCount());
        }
    }
}
