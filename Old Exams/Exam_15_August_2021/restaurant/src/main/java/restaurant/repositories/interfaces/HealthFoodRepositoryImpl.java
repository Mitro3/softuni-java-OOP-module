package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.Food;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<Food> {

    private Map<String, Food> foods;


    @Override
    public Food foodByName(String name) {
        Food food = foods.get(name);

        return food;
    }

    @Override
    public Collection<Food> getAllEntities() {
        return Collections.unmodifiableCollection(foods.values());
    }

    @Override
    public void add(Food entity) {
        foods.put(entity.getName(), entity);
    }
}
