package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class CarRepository implements Repository<Car> {

    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return cars.stream()
                .filter(car -> car.getModel().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return cars;
    }

    @Override
    public void add(Car model) {
        cars.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return cars.remove(model);
    }

}
