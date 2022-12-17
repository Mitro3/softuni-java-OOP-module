package christmasRaces.entities.cars;
import static christmasRaces.common.ExceptionMessages.*;


public class MuscleCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS = 5000.00;
    private static final int MINIMUM_HORSE_POWER = 400;
    private static final int MAXIMUM_HORSE_POWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSE_POWER || horsePower > MAXIMUM_HORSE_POWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

        this.horsePower = horsePower;
    }
}
