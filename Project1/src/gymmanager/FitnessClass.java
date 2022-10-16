package gymmanager;
/**
 * Used to create new Fitness Class objects that hold the name of the class and instructor, time, list of participants,
 * and the size of the class.
 * @author Aaron Newland, Dylan Pina
 */
public class FitnessClass {
    private String className;
    private String instructorName;
    private Time time;
    private Location location;
    private Member[] participants;
    private int classSize;

    /**
     * Default constructor for FitnessClass, fills with null values.
     */
    public FitnessClass() {
        this.className = null;
        this.instructorName = null;
        this.time = null;
        this.location = null;
        this.participants = new Member[100];
        this.classSize = 0;
    }

    /**
     * Creates new FitnessClass object with className value.
     * @param className name of fitness class.
     */
    public FitnessClass(String className) {
        this.className = className;
        this.instructorName = null;
        this.time = null;
        this.location = null;
        this.participants = new Member[100];
        this.classSize = 0;
    }

    /**
     * Creates new FitnessClass object with given values.
     * @param className name of fitness class.
     * @param instructorName name of instructor teaching fitness class.
     * @param time time that fitness class is being held.
     */
    public FitnessClass(String className, String instructorName, Time time, Location location) {
        this.className = className;
        this.instructorName = instructorName;
        this.time = time;
        this.location = location;
        this.participants = new Member[100];
        this.classSize = 0;
    }

    /**
     * Checks member in for fitness class.
     * @param member member checking into class.
     * @return true if member gets checked in.
     */
    public boolean checkIn(Member member) {
        participants[classSize++] = member;
        System.out.println(member.getFname() + " " + member.getLname() + " checked in " + className + ".");
        return true;
    }

    /**
     * Drops member from fitness class.
     * @param member member dropping from class.
     * @return true if member drops class.
     */
    public boolean checkOut(Member member) {
        int participantIndex = getParticipantIndex(member);
        if (participantIndex == -1) return false;

        Member[] newList = new Member[classSize--];
        for (int i = 0; i < classSize; i++)
            if (i == participantIndex) newList[i] = participants[i + 1];
            else newList[i] = participants[i];
        participants = newList;

        System.out.println(member.getFname() + " " + member.getLname() + " dropped " + className + ".");
        return true;
    }



    /**
     * Checks if member is checked into class already.
     * @param member member to check against class list.
     * @return true if member is already checked in, false otherwise.
     */
    public boolean participantCheckedIn(Member member) {
        if (classSize != 0)
            for (Member m : participants)
                if (m != null && m.equals(member)) return true;
        return false;
    }

    /**
     * Retrieves index of member registered for fitness class.
     * @param member member used to search class registration list.
     * @return index of member registered for fitness class, -1 otherwise.
     */
    private int getParticipantIndex(Member member) {
        for (int i = 0; i <= classSize; i++)
            if (participants[i] != null && member.equals(participants[i]))
                return i;
        return -1;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Prints name of fitness class, name of instructor, time of class, and information for all members registered for
     * each class.
     */
    @Override
    public String toString() {
        StringBuilder classStr = new StringBuilder();
        classStr.append(className + " - " + instructorName.toUpperCase() + ", " + time  + ", " + location.name());
        if (classSize != 0) {
            classStr.append("\n    ** participants **");
            for (Member m : participants)
                if (m != null) classStr.append("\n       " + m);
        }
        return classStr.toString();
    }
}