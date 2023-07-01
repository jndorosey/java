public class TestAFLTeam {
    public static void main(String[] args) {
        AFLTeamMember coach = new AFLTeamMember("Simon Goodwin", "COACH");
        AFLTeam team = new AFLTeam("Melbourne Demons", coach);

        AFLPlayer player1 = new AFLPlayer("Adam Treloar", "HF", 1, false);
        AFLPlayer player2 = new AFLPlayer("Max Gawn", "FOL", 11, true);

        team.addPlayer(player1);
        team.addPlayer(player2);

        System.out.println(team);
    }
}
