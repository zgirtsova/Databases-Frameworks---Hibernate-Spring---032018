package P10_Beer_Counter;

class BeerCounter {
    private static int beerInStock = 0;
    private static int beerDrankCount = 0;

    public static void BuyBeer(int bottlesCount){
        if (bottlesCount > 0)
            beerInStock+=bottlesCount;
    }

    public static void DrinkBeer(int bottlesCount){
        if(beerInStock >= bottlesCount){
            beerInStock-= bottlesCount;
            beerDrankCount += bottlesCount;
        }
    }

    public static int getBeerInStock() {
        return beerInStock;
    }

    public static int getBeerDrankCount() {
        return beerDrankCount;
    }
}
