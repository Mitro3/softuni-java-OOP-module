package restaurant.entities.drinks.interfaces;

public class Smoothie extends BaseBeverage {

    private static final double PRICE = 4.50;

    public Smoothie(String name, int count, String brand) {
        super(name, count, PRICE, brand);
    }
}
