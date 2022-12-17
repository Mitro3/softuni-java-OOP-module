package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static final int INITIAL_KILOGRAMS = 7;
    private static final int INCREASE_KILOGRAMS = 1;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        int newKG = 0;

        if (getKilograms() == 0) {
            newKG = INITIAL_KILOGRAMS + INCREASE_KILOGRAMS;
        } else {
            newKG = getKilograms() + INCREASE_KILOGRAMS;
        }

        setKilograms(newKG);
    }
}
