package restaurant.entities.drinks.interfaces;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseBeverage implements Beverages {

    private String name;
    private int count;
    private double price;
    private String brand;

    public BaseBeverage(String name, int count, double price, String brand) {
        this.setName(name);
        this.setCount(count);
        this.setPrice(price);
        this.setBrand(brand);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        this.name = name;
    }

    @Override
    public int getCounter() {
        return count;
    }

    public void setCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(INVALID_COUNTER);
        }

        this.count = count;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }

        this.brand = brand;
    }
}
