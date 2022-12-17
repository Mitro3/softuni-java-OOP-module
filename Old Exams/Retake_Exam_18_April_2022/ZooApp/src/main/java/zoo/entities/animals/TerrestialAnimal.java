package zoo.entities.animals;

public class TerrestialAnimal extends BaseAnimal {

    private static final double KG = 5.50;
    private static final double KG_TO_INCREASE_WHEN_EAT = 5.70;

    public TerrestialAnimal(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    @Override
    public void eat() {
        double newKG = getKg() + KG_TO_INCREASE_WHEN_EAT;
        setKg(newKG);
    }
}
