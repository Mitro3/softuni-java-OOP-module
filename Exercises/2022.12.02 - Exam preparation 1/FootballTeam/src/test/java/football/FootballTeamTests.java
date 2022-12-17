package football;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private Footballer footballer;
    private FootballTeam footballTeam;
    private static final int VACANT_POSITIONS = 11;
    private static final String PLAYER_NAME = "Pesho";
    private static final String TEAM_NAME = "Pesho's team";

    @Before
    public void setUp () {
        this.footballer = new Footballer(PLAYER_NAME);
        this.footballTeam = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTeamWithNoVacantPositions() {
        new FootballTeam("test_name", -1);
    }

    @Test
    public void testCreatingTeamActualPositionsShouldSetCorrectPositionsCount() {
        assertEquals(11, footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithNullNameShouldFail() {
        new FootballTeam(null, VACANT_POSITIONS);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithEmptyNameShouldFail() {
        new FootballTeam("   ", VACANT_POSITIONS);
    }

    @Test
    public void testCreatingTeamWithNameShouldSetTheName() {
        new FootballTeam(TEAM_NAME, VACANT_POSITIONS);
    }

    @Test
    public void testAddPlayerShouldIncreaseTeamPositionsCount() {
        assertEquals(0, footballTeam.getCount());
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerShouldFailWhenTeamIsFull() {
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);
        team.addFootballer(footballer);
    }

    @Test
    public void testRemovePlayerShouldReduceTeamCount() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
        footballTeam.removeFootballer(footballer.getName());
        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerShouldFailWhenNoSuchPlayer() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
        footballTeam.removeFootballer("not_added");
    }

    @Test
    public void testPlayerForSaleShouldDeactivatePlayer() {
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForSaleShouldFailWhenPlayerMissing() {
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("not_added");
    }


}
