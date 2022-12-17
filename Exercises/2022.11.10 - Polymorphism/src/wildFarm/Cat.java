package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight,livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) throws Exception {
        super.eat(food);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        String output = String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(), getAnimalName(), breed,
                df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());

        return output;
    }
}
