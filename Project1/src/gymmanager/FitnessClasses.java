package gymmanager;
/**
 * Holds enumeration data for fitness classes: Class name, instructor name, and time.
 * @author Aaron Newland, Dylan Pina
 */
public enum FitnessClasses {
    Pilates("JENNIFER", Time.PILATES),
    Spinning("DENISE", Time.SPINNING),
    Cardio("KIM", Time.CARDIO);

    private String instructorName;
    private Time time;

    /**
     * Creates new FitnessClasses object
     * @param instructorName name of instructor teaching fitness class.
     * @param time time that fitness class is being held.
     */
    FitnessClasses(String instructorName, Time time) {
        this.instructorName = instructorName;
        this.time = time;
    }

    /**
     * Get name of fitness instructor.
     * @return name of fitness instructor.
     */
    public String getInstructorName() {
        return instructorName;
    }

    /**
     * Get time of fitness class.
     * @return time of fitness class.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Provides a string representation of a FitnessClasses object.
     * @return String of FitnessClasses object.
     */
    @Override
    public String toString() {
        return name() + "- " + getInstructorName() + " " + getTime();
    }
}