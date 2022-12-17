package fairyShop.models;

import static fairyShop.common.ExceptionMessages.*;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;
    private static final int ENERGY_TO_DECREASE_WHEN_CRAFTING = 10;

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }

    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PRESENT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getEnergyRequired() {
        return energyRequired;
    }

    protected void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException(PRESENT_ENERGY_LESS_THAN_ZERO);
        }

        this.energyRequired = energyRequired;
    }

    @Override
    public boolean isDone() {
        return energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        if (energyRequired - ENERGY_TO_DECREASE_WHEN_CRAFTING < 0) {
            setEnergyRequired(0);
        } else {
            setEnergyRequired(energyRequired - ENERGY_TO_DECREASE_WHEN_CRAFTING);
        }
    }
}
