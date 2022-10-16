package gymmanager;
/**
 * Holds enumeration data for the times that the fitness classes are held at.
 * @author Aaron Newland, Dylan Pina
 */
public enum Time {
    //TODO: change to morning, afternoon, evening
    PILATES(9, 30),
    SPINNING(14, 00),
    CARDIO(14, 00);

    private final int hour;
    private final int minutes;

    /**
     * Creates new Time object using provided int values.
     * @param hour hour given in int.
     * @param minutes minutes given in int.
     */
    Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    /**
     * Provides a string representation of a Time object.
     * @return String of Time object.
     */
    @Override
    public String toString() {
        return hour + ":" + String.format("%02d", minutes);
    }
}
