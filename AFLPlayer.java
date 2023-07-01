public class AFLPlayer extends AFLTeamMember {
    private int number;
    private boolean isCaptain;

    public AFLPlayer(String name, String position, int number, boolean isCaptain) {
        super(name, position);
        setNumber(number);
        setIsCaptain(isCaptain);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        } else {
            System.out.println("Invalid number: " + number);
            this.number = -1;
        }
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setIsCaptain(boolean isCaptain) {
        this.isCaptain = isCaptain;
    }

    @Override
    public String toString() {
        String captainIndicator = isCaptain ? " (c)" : "";
        return "[" + number + "] " + super.toString() + captainIndicator;
    }
}
