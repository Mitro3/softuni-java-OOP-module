package wildFarm;

public interface eatVegatables {

    default void eat(Food food) throws Exception {
        if (!(food instanceof Vegetable)) {
            throw new Exception(String.format("%s are not eating that type of food!", getClass().getSimpleName()));
        }
    }
}
