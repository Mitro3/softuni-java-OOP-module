package zoo.entities.animals;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseAnimal implements Animal {

    private String name;
    private String kind;
    private double kg;
    private double price;

    protected BaseAnimal(String name, String kind, double kg, double price) {
        this.setName(name);
        this.setKind(kind);
        this.setKg(kg);
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        throwExcForNullOrEmptyInput(name, ANIMAL_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    protected void setKind(String kind) {
        throwExcForNullOrEmptyInput(kind, ANIMAL_KIND_NULL_OR_EMPTY);
        this.kind = kind;
    }

    @Override
    public double getKg() {
        return kg;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }

        this.price = price;
    }

    private void throwExcForNullOrEmptyInput(String input, String message) {
        if (input == null || input.trim().isEmpty()) {
            throw new NullPointerException(message);
        }
    }

}
