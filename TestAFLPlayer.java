public class TestAFLPlayer {
    public static void main(String[] args) {
        AFLPlayer player1 = new AFLPlayer("Adam Treloar", "HF", 1, false);
        System.out.println(player1);

        player1.setNumber(-5);
        System.out.println(player1);

        player1.setNumber(10);
        System.out.println(player1);

        player1.setIsCaptain(true);
        System.out.println(player1);
    }
}
