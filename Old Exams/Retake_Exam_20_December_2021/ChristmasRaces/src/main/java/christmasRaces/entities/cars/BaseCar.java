package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.*;

public abstract class BaseCar implements Car {

    private String model;
    protected int horsePower;
    private double cubicCentimeters;
    private static final int MINIMUM_SYMBOLS = 4;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    @Override
    public String getModel() {
        return model;
    }

    protected void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < MINIMUM_SYMBOLS) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, MINIMUM_SYMBOLS));
        }

        this.model = model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    protected abstract void setHorsePower(int horsePower);

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    protected void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        double racePoints = cubicCentimeters / horsePower * laps;
        return racePoints;
    }
}
