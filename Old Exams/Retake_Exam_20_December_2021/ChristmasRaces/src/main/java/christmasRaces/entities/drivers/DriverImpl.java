package christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;

import static christmasRaces.common.ExceptionMessages.*;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;
    private static final int MINIMUM_NAME_LENGTH = 5;

    public DriverImpl(String name) {
        this.setName(name);
        this.canParticipate = false;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, MINIMUM_NAME_LENGTH));
        }

        this.name = name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }

        this.car = car;
        setCanParticipate(car);
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }

    private void setCanParticipate(Car car) {
        this.canParticipate = true;
    }
}
