package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        houses.add(house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House house = getHouseByName(houseName);
        house.buyToy(toy);
        toys.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = getHouseByName(houseName);

        String addReport;

        if (!suitableHome(catType, house)) {
            addReport = UNSUITABLE_HOUSE;
        } else {
            addReport = String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
            house.addCat(cat);
        }

        return addReport;
    }

    private boolean suitableHome(String catType, House house) {
        return (catType.equals("ShorthairCat") && house.getClass().getSimpleName().equals("ShortHouse"))
                || (catType.equals("LonghairCat") && house.getClass().getSimpleName().equals("LongHouse"));
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouseByName(houseName);
        house.feeding();
        int catsFed = house.getCats().size();

        return String.format(FEEDING_CAT,catsFed);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = getHouseByName(houseName);
        double catsPriceSum = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysPriceSum = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double totalSum = catsPriceSum + toysPriceSum;

        return String.format(VALUE_HOUSE, houseName, totalSum);
    }

    @Override
    public String getStatistics() {
        return houses.stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }

    private House getHouseByName(String houseName) {
        House house = houses.stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);
        return house;
    }
}
