package wildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) throws Exception {
        if (!(food instanceof Vegetable)) {
            throw new Exception("Zebras are not eating that type of food!");
        }

        super.eat(food);
    }
}
