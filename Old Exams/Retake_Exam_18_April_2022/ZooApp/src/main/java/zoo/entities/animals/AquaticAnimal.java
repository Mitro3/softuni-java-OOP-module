package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {

    private static final double KG = 2.50;
    private static final double KG_TO_INCREASE_WHEN_EAT = 7.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    @Override
    public void eat() {
        double newKg = getKg() + KG_TO_INCREASE_WHEN_EAT;
        setKg(newKg);
    }
}
