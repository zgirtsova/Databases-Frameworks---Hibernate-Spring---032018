package LAB.car;

public class Seat implements Sellable{

    private String countryProduced;
    private String model;
    private String color;
    private int horsePower;
    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    public Seat(String model, String color, int horsePower, String countryProduced, double price) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.price = price;
    }

    public String getCountryProduced() {
        return countryProduced;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
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
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String stringSeat = String.format(
                "This is %s produced in %s and have %d tires",
                this.model, this.countryProduced, this.TIRES);
        return stringSeat;
    }
}
