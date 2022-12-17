package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class DriverRepository implements Repository<Driver> {
    Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return drivers.stream()
                .filter(d -> d.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return drivers;
    }

    @Override
    public void add(Driver model) {
        drivers.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return drivers.remove(model);
    }
}
