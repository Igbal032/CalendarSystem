package my.project.calendarsystem.enums;

public enum Color {
    RED(5),
    ORANGE(10),
    YELLOW(20),
    BLUE(21);

    private final int day;

    // private enum constructor
    private Color(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
