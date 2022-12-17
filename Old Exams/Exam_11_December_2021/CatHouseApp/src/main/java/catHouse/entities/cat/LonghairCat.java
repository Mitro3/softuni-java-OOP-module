package catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private static final int INITIAL_KILOGRAMS = 9;
    private static final int INCREASE_KILOGRAMS = 3;

    public LonghairCat(String name, String breed, double price) {
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
