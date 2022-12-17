package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import java.util.Collections;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = new DelicacyRepositoryImpl();
        this.cocktailRepository = new CocktailRepositoryImpl();
        this.boothRepository = new BoothRepositoryImpl();
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getAll().stream().filter(d -> d.getName().equals(name))
                .findAny()
                .orElse(null);

        if (delicacy != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        if (type.equals("Gingerbread")) {
            delicacy = new Gingerbread(name, price);
        } else if (type.equals("Stolen")) {
            delicacy = new Stolen(name, price);
        }

        delicacyRepository.add(delicacy);

        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getAll().stream().filter(c -> c.getName().equals(name))
                .findAny()
                .orElse(null);

        if (cocktail != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        if (type.equals("MulledWine")) {
            cocktail = new MulledWine(name, size, brand);
        } else if (type.equals("Hibernation")) {
            cocktail = new Hibernation(name, size, brand);
        }

        cocktailRepository.add(cocktail);

        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getAll().stream().filter(b -> b.getBoothNumber() == boothNumber)
                .findAny()
                .orElse(null);

        if (booth != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        if (type.equals("OpenBooth")) {
            booth = new OpenBooth(boothNumber, capacity);
        } else if (type.equals("PrivateBooth")) {
            booth = new PrivateBooth(boothNumber, capacity);
        }

        boothRepository.add(booth);

        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = boothRepository.getAll().stream()
                .filter(b -> !b.isReserved())
                .filter(b -> b.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (booth == null) {
            String output = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
            return output;
        }

        booth.reserve(numberOfPeople);

        return String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getAll().stream()
                .filter(b -> b.getBoothNumber() == boothNumber)
                .findAny()
                .orElse(null);

        double bill = booth.getBill();
        booth.clear();
        totalIncome += bill;

        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
