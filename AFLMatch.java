import java.util.Scanner;
import java.io.*;

public class AFLMatch {
    private AFLTeam homeTeam;
    private AFLTeam awayTeam;
    private int homeGoals;
    private int homeBehinds;
    private int awayGoals;
    private int awayBehinds;

    public static void main(String[] args) {
        AFLMatch match = new AFLMatch();

        if (args.length != 2) {
            System.out.println("Please provide two team filenames as arguments.");
            return;
        }

        match.homeTeam = loadTeam(args[0]);
        match.awayTeam = loadTeam(args[1]);

        if (match.homeTeam == null || match.awayTeam == null) {
            System.out.println("Error loading teams.");
            return;
        }

        match.runMatch();
    }

    public void runMatch() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Which team scored? ('h' for home team, 'a' for away team, 'f' for full time)");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("f")) {
                displayFinalScore();
                break;
            }

            boolean homeScored = input.equalsIgnoreCase("h");
            boolean awayScored = input.equalsIgnoreCase("a");

            if (!homeScored && !awayScored) {
                System.out.println(
                        "Invalid input! Please enter 'h' for home team, 'a' for away team, or 'f' for full time.");
                continue; // Restart the loop to prompt for valid input
            }

            System.out.println("Goal or behind? ('g' for goal, 'b' for behind)");
            input = scanner.nextLine();

            boolean isGoal = input.equalsIgnoreCase("g");
            boolean isBehind = input.equalsIgnoreCase("b");

            if (!isGoal && !isBehind) {
                System.out.println("Invalid input! Please enter 'g' for goal or 'b' for behind.");
                continue; // Restart the loop to prompt for valid input
            }

            if (homeScored) {
                if (isGoal) {
                    homeGoals++;
                } else {
                    homeBehinds++;
                }
            } else {
                if (isGoal) {
                    awayGoals++;
                } else {
                    awayBehinds++;
                }
            }

            displayCurrentScore();
        }

        scanner.close();
    }

    public void displayCurrentScore() {
        int homeScore = homeGoals * 6 + homeBehinds;
        int awayScore = awayGoals * 6 + awayBehinds;

        System.out.printf("Current score:\n%s %d.%d (%d) - %s %d.%d (%d)\n",
                homeTeam.getName(), homeGoals, homeBehinds, homeScore,
                awayTeam.getName(), awayGoals, awayBehinds, awayScore);
    }

    public static AFLTeam loadTeam(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            String teamName = sc.nextLine().trim();
            String coachDetails = sc.nextLine().trim();
            String[] coachDetailsSplit = coachDetails.split(",");
            AFLTeamMember coach = new AFLTeamMember(coachDetailsSplit[0].trim(), coachDetailsSplit[1].trim());
            AFLTeam team = new AFLTeam(teamName, coach);

            while (sc.hasNextLine()) {
                String playerDetails = sc.nextLine().trim();
                System.out.println("Parsing player: " + playerDetails); // Debug statement
                String[] playerDetailsSplit = playerDetails.split(",");
                int number = Integer.parseInt(playerDetailsSplit[0].trim());
                String name = playerDetailsSplit[1].trim();
                String position = playerDetailsSplit[2].trim();
                boolean isCaptain = false;
                if (playerDetailsSplit.length == 4 && playerDetailsSplit[3].trim().equals("c")) {
                    isCaptain = true;
                }
                AFLPlayer player = new AFLPlayer(name, position, number, isCaptain);
                team.addPlayer(player);
            }

            sc.close();
            return team;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void displayFinalScore() {
        int homeScore = homeGoals * 6 + homeBehinds;
        int awayScore = awayGoals * 6 + awayBehinds;
        String result;

        if (homeScore > awayScore) {
            result = String.format("%s %d.%d (%d) defeated %s %d.%d (%d).",
                    homeTeam.getName(), homeGoals, homeBehinds, homeScore,
                    awayTeam.getName(), awayGoals, awayBehinds, awayScore);
        } else if (homeScore < awayScore) {
            result = String.format("%s %d.%d (%d) defeated %s %d.%d (%d).",
                    awayTeam.getName(), awayGoals, awayBehinds, awayScore,
                    homeTeam.getName(), homeGoals, homeBehinds, homeScore);
        } else {
            result = String.format("%s %d.%d (%d) drew with %s %d.%d (%d).",
                    homeTeam.getName(), homeGoals, homeBehinds, homeScore,
                    awayTeam.getName(), awayGoals, awayBehinds, awayScore);
        }

        System.out.println("FULL TIME\n\n" + result);
    }
}
