package fairyShop.models;

public class Sleepy extends BaseHelper {

    private static final int ENERGY_TO_DECREASE = 15;

    public Sleepy(String name) {
        super(name, 50);
    }

    @Override
    public void work() {
        if (getEnergy() - ENERGY_TO_DECREASE < 0) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy() - ENERGY_TO_DECREASE);
        }
    }
}
