package fairyShop.models;

import static fairyShop.common.ExceptionMessages.*;

public class InstrumentImpl implements Instrument {

    private int power;
    private static final int POWER_TO_DECREASE_WHEN_USE = 10;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return power;
    }

    protected void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }

        this.power = power;
    }

    @Override
    public void use() {
        if (power - POWER_TO_DECREASE_WHEN_USE < 0) {
            setPower(0);
        } else {
            setPower(power - POWER_TO_DECREASE_WHEN_USE);
        }
    }

    @Override
    public boolean isBroken() {
        return power == 0;
    }
}
