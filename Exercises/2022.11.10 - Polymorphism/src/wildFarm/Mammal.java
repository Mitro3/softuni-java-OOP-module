package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        String output = String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(), getAnimalName(), df.format(getAnimalWeight()),
                getLivingRegion(), getFoodEaten());

        return output;
    }
}
