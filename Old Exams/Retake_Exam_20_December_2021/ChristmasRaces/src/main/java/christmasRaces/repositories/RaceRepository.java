package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.races.Race;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository implements Repository<Race> {
    Collection<Race> races;
    Collection<Driver> drivers;

    public RaceRepository() {
        this.races = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return races.stream()
                .filter(r -> r.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return races;
    }

    @Override
    public void add(Race model) {
        races.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return races.remove(model);
    }
}
