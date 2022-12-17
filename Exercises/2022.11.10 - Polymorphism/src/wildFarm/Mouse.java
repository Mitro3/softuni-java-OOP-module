package wildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }



    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) throws Exception {
        if (!(food instanceof Vegetable)) {
            throw new Exception("Mice are not eating that type of food!");
        }

        super.eat(food);
    }
}
