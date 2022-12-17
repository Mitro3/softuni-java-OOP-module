package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Collection<Driver> drivers;
    private static final int MINIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NUMBER_OF_LAPS = 1;


    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_NUMBER_OF_LAPS) {
            throw  new IllegalArgumentException(String.format(INVALID_NAME, name, MINIMUM_NAME_LENGTH));
        }

        this.name = name;
    }

    private void setDrivers(Collection<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, MINIMUM_NUMBER_OF_LAPS));
        }

        this.laps = laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        Driver existingDriver = drivers.stream()
                .filter(d -> d.getName().equals(driver.getName()))
                .findAny()
                .orElse(null);

        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        } else if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        } else if (existingDriver != null) {
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver.getName(), name));
        }

        drivers.add(driver);
    }
}
