public class AFLTeamMember {
    private String name;
    private String position;

    public AFLTeamMember(String name, String position) {
        setName(name);
        setPosition(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (isValidPosition(position)) {
            this.position = position;
        } else {
            System.out.println("Invalid position: " + position);
            this.position = "";
        }
    }

    private boolean isValidPosition(String position) {
        String[] validPositions = {"FB", "HB", "C", "HF", "FF", "FOL", "IC", "COACH"};
        for (String validPosition : validPositions) {
            if (validPosition.equals(position)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return name + ", " + position;
    }
}
