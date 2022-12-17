package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Map<String, Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new LinkedHashMap<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        Beverages beverage = beverages.get(drinkName);
        return beverage;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(beverages.values());
    }

    @Override
    public void add(Beverages entity) {
        beverages.put(entity.getName(), entity);
    }
}
