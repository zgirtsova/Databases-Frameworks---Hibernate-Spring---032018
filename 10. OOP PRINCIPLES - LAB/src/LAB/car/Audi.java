package LAB.car;

public class Audi implements Rentable {

    String model;
    String color;
    int horsePower;
    int minRentDays;
    double pricePerDay;

    public Audi(String model, String color, int horsePower, int minRentDays, double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.minRentDays = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public int getMinRentDays() {
        return this.minRentDays;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        String stringSeat = String.format(
                "The car is model %s, with horse power %d and color %s, price per day %.2f and minimal" +
                        "rent days %d",
                this.model, this.horsePower, this.color, this.pricePerDay, this.minRentDays);
        return stringSeat;
    }
}
