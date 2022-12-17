package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhibitsInState = state.getExhibits();

        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && !exhibitsInState.isEmpty()) {
                explorer.search();
                String currExhibit = exhibitsInState.iterator().next();
                explorer.getSuitcase().getExhibits().add(currExhibit);
                exhibitsInState.remove(currExhibit);
            }
        }
    }
}
