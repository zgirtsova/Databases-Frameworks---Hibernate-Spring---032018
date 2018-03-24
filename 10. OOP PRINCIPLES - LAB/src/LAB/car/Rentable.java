package LAB.car;

public interface Rentable extends Car {

    public static int minRentDays = 0;
    public static double pricePerDay = 0;

    public int getMinRentDays();
    double getPricePerDay();
}
