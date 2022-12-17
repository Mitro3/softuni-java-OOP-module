package footBallTeamGenerator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        String commandLine = scanner.nextLine();

        while (!"END".equals(commandLine)) {
            String[] commandData = commandLine.split(";");
            String command = commandData[0];
            String teamName = commandData[1];

            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                        break;

                    case "Add":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                            break;
                        }

                        String playerName = commandData[2];
                        int endurance = Integer.parseInt(commandData[3]);
                        int sprint = Integer.parseInt(commandData[4]);
                        int dribble = Integer.parseInt(commandData[5]);
                        int passing = Integer.parseInt(commandData[6]);
                        int shooting = Integer.parseInt(commandData[7]);

                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        }
                        break;

                    case "Remove":
                        String playerToRemove = commandData[2];
                        teams.get(teamName).removePlayer(playerToRemove);
                        break;

                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            commandLine = scanner.nextLine();
        }
    }
}
