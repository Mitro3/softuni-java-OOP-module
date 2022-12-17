package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer {

    private static final double STARTING_ENERGY = 40.00;

    public Anthropologist(String name) {
        super(name, STARTING_ENERGY);
    }
}
