package gymmanager;

import java.text.DecimalFormat;

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
    private Member[] guests;
    private int participantSize;
    private int guestSize;

    /**
     * Default constructor for FitnessClass, fills with null values.
     */
    public FitnessClass() {
        this.className = null;
        this.instructorName = null;
        this.time = null;
        this.location = null;
        this.participants = new Member[100];
        this.guests = new Member[100];
        this.participantSize = 0;
        this.guestSize = 0;
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
        this.guests = new Member[100];
        this.participantSize = 0;
        this.guestSize = 0;
    }

    /**
     * Creates new FitnessClass object with given values.
     * @param className name of fitness class.
     * @param instructorName name of instructor teaching fitness class.
     * @param location location of the fitness class.
     */
    public FitnessClass(String className, String instructorName, Location location) {
        this.className = className;
        this.instructorName = instructorName;
        this.time = null;
        this.location = location;
        this.participants = new Member[100];
        this.guests = new Member[100];
        this.participantSize = 0;
        this.guestSize = 0;

    }

    /**
     * Creates new FitnessClass object with given values.
     * @param className name of fitness class.
     * @param instructorName name of instructor teaching fitness class.
     * @param time time of the fitness class.
     * @param location location of the fitness class.
     */
    public FitnessClass(String className, String instructorName, Time time, Location location) {
        this.className = className;
        this.instructorName = instructorName;
        this.time = time;
        this.location = location;
        this.participants = new Member[100];
        this.guests = new Member[100];
        this.participantSize = 0;
        this.guestSize = 0;
    }

    /**
     * Checks member in for fitness class.
     * @param member member checking into class.
     * @return true if member gets checked in.
     */
    public boolean checkIn(Member member) {
        participants[participantSize++] = member;
        return true;
    }

    /**
     * Checks guest in for fitness class.
     * @param member member's account that guest is using to check into class.
     * @return true if member's guest gets checked in.
     */
    public boolean checkInGuest(Member member) {
        guests[guestSize++] = member;
        return true;
    }

    /**
     * Drops member from fitness class.
     * @param member member dropping from class.
     * @return true if member drops class.
     */
    public boolean checkout(Member member) {
        int participantIndex = getParticipantIndex(member);
        if (participantIndex == Constants.NOT_FOUND) return false;

        Member[] newList = new Member[participants.length];
        participantSize--;
        for (int i = 0; i < participantSize; i++)
            if (i == participantIndex) newList[i] = participants[i++ + 1];
            else newList[i] = participants[i];
        participants = newList;

        return true;
    }

    /**
     * Drops member's guest from fitness class.
     * @param member member's account that guest is using to drop from class.
     * @return true if member's guest drops class.
     */
    public boolean checkoutGuest(Member member) {
        int guestIndex = getGuestIndex(member);
        if (guestIndex == Constants.NOT_FOUND) return false;

        Member[] newList = new Member[guests.length];
        guestSize--;
        for (int i = 0; i < guestSize; i++)
            if (i == guestIndex) newList[i] = guests[i++ + 1];
            else newList[i] = guests[i];
        guests = newList;

        return true;
    }

    /**
     * Checks if member is checked into class already.
     * @param member member to check against class list.
     * @return true if member is already checked in, false otherwise.
     */
    public boolean participantCheckedIn(Member member) {
        if (participantSize != 0)
            for (Member m : participants)
                if (m != null && m.equals(member)) return true;
        return false;
    }

    /**
     * Checks if guest is checked into class already.
     * @param member member's account to check against guest list.
     * @return true if guest is already checked in, false otherwise.
     */
    public boolean guestCheckedIn(Member member) {
        if (guestSize != 0)
            for (Member m : guests)
                if (m != null && m.equals(member)) return true;
        return false;
    }

    /**
     * Retrieves index of member registered for fitness class.
     * @param member member used to search class registration list.
     * @return index of member registered for fitness class, -1 otherwise.
     */
    private int getParticipantIndex(Member member) {
        for (int i = 0; i <= participantSize; i++)
            if (participants[i] != null && member.equals(participants[i]))
                return i;
        return -1;
    }

    /**
     * Retrieves index of guest registered for fitness class.
     * @param member member's account used to search guest registration list.
     * @return index of guest registered for fitness class, -1 otherwise.
     */
    private int getGuestIndex(Member member) {
        for (int i = 0; i <= guestSize; i++)
            if (guests[i] != null && member.equals(guests[i]))
                return i;
        return -1;
    }

    /**
     * Gets name of instructor.
     * @return name of instructor.
     */
    public String getInstructorName() {
        return instructorName;
    }

    /**
     * Sets name of instructor.
     * @param instructorName name of instructor
     */
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    /**
     * Gets the time of the class.
     * @return time of the class.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets time of the class.
     * @param time time of the class.
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Gets the location of the class.
     * @return location of the class.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the location of the class.
     * @return location of the class.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets the name of the class.
     * @return name of the class.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the name of the class.
     * @return name of the class.
     */
    public Member[] getParticipants() {
        return participants;
    }

    /**
     * Creates string including the class name, instructor name, time, and location.
     * Does not contain list of participants.
     * @return string containing class data without participants
     */
    public String printNoParticipants() {
        DecimalFormat zipCodeFormat = new DecimalFormat("00000");
        return className + " - " + instructorName.toUpperCase() + ", " + time  + ", " + location.name() + ", " +
                zipCodeFormat.format(location.getZip()) + ", " + location.getCounty();
    }

    /**
     * Determines if a fitness class is equal to another fitness class.
     * Class name, instructor name, and location are the same.
     * @param obj FitnessClass to check if equal to another FitnessClass.
     * @return true if FitnessClass is equal to other FitnessClass, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (className.equalsIgnoreCase(((FitnessClass) obj).getClassName())
                && (instructorName.equalsIgnoreCase(((FitnessClass) obj).getInstructorName())
                && (location.equals(((FitnessClass) obj).getLocation())))) return true;
        return false;
    }

    /**
     * Creates a string containing the name of fitness class, name of instructor, time of class, and information
     * for all members and guests registered for each class.
     * @return string containing all class data
     */
    @Override
    public String toString() {
        StringBuilder classStr = new StringBuilder();
        classStr.append(className + " - " + instructorName.toUpperCase() + ", " + time  + ", " + location.name());

        boolean hasParticipants = participantSize != 0;
        boolean hasGuests = guestSize != 0;

        if (hasParticipants || hasGuests) classStr.append("\n");
        if (hasParticipants) {
            classStr.append("- Participants -\n");
            for (int i = 0; i < participantSize; i++)
                if (participants[i] != null) {
                    classStr.append("   " + participants[i]);
                    if (participants[i + 1] != null) classStr.append("\n");
                }
        }

        if (hasParticipants && hasGuests) classStr.append("\n");
        if (hasGuests) {
            classStr.append("- Guests -\n");
            for (int i = 0; i < guestSize; i++)
                if (guests[i] != null) {
                    classStr.append("   " + guests[i]);
                    if (guests[i + 1] != null) classStr.append("\n");
                }
        }

        return classStr.toString();
    }
}