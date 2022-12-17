package wildFarm;

public class Tiger extends Felime {

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) throws Exception {
        if (!(food instanceof Meat)) {
            throw new Exception("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }
}
