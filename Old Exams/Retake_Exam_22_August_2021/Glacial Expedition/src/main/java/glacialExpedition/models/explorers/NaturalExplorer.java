package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double INITIAL_ENERGY = 60.00;
    private static final double DECREASE_ENERGY_WHEN_SEARCH = 7.00;


    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        setEnergy(Math.max(0, getEnergy() - DECREASE_ENERGY_WHEN_SEARCH));
    }
}
