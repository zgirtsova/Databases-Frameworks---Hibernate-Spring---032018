package LAB.car;

public class Main {
    public static void main(String[] args) {
        Car car = new Seat("Seat", "Blue", 100, "Germany");
        car.toString();

        car = new Audi("Audi", "red", 100, 1, 12.3);
        car.toString();

        Car seat = new Seat("Leon", "gray", 110, "Spain");

                System.out.println(String.format(
                        "%s is %s color and have %s horse power",
                        seat.getModel(),
                        seat.getColor(),
                        seat.getHorsePower()));
        System.out.println(seat.toString());

    }
}
