import java.util.ArrayList;

public class AFLTeam {
    private String name;
    private AFLTeamMember coach;
    private ArrayList<AFLPlayer> lineup;

    public AFLTeam(String name, AFLTeamMember coach) {
        this.name = name;
        this.coach = coach;
        this.lineup = new ArrayList<>(22);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AFLTeamMember getCoach() {
        return coach;
    }

    public void setCoach(AFLTeamMember coach) {
        this.coach = coach;
    }

    public ArrayList<AFLPlayer> getLineup() {
        return lineup;
    }

    public void addPlayer(AFLPlayer player) {
        if (lineup.size() < 22) {
            lineup.add(player);
        } else {
            System.out.println("Lineup is full. Cannot add more players.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team Name: ").append(name).append("\n");
        sb.append("Coach: ").append(coach).append("\n");
        sb.append("Lineup:\n");

        for (AFLPlayer player : lineup) {
            sb.append(player).append("\n");
        }

        return sb.toString();
    }
}
