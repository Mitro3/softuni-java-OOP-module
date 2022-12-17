package footBallTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        ifNotValidInput(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        ifNotValidInput(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        ifNotValidInput(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        ifNotValidInput(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        ifNotValidInput(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void ifNotValidInput(int value, String skill) {
        if (value < 0 || value > 100) {
            String errorMessage = String.format("%s should be between 0 and 100.", skill);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }
}
