public class TestAFLTeamMember {
    public static void main(String[] args) {
        // AFLTeamMember instance
        AFLTeamMember teamMember1 = new AFLTeamMember("Simon Goodwin", "COACH");

        // Print the string representation of the AFLTeamMember instance
        System.out.println(teamMember1);

        // Test invalid position
        teamMember1.setPosition("INVALID_POSITION");

        // Test valid position
        teamMember1.setPosition("FB");
        System.out.println(teamMember1);
    }
}
