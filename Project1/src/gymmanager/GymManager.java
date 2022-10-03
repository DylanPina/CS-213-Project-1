package gymmanager;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Main input/output class. Continuously reads input from user, determines command, then executes necessary methods.
 * @author Aaron Newland, Dylan Pina
 */
public class GymManager {
    StringTokenizer st;
    MemberDatabase db;
    FitnessClass pilates;
    FitnessClass spinning;
    FitnessClass cardio;

    /**
     * Creates a new MemberDatabase object, initializes fitness classes, and takes input from user until 'Q' is read.
     */
    public void run() {
        db = new MemberDatabase();
        initFitnessClasses();
        System.out.println("Gym Manager running...");
        Scanner s = new Scanner(System.in);

        while (true) {
            String workingLine;
            int tokensRead = 0;

            workingLine = s.nextLine();
            st = new StringTokenizer(workingLine);

            while (st.hasMoreTokens()) {
                if (tokensRead == 0) setCommand(st.nextToken());
                else break;
                tokensRead--;
            }
        }
    }

    /**
     * Selects the appropriate operation using the operation code given.
     * If operation code is not listed then it is an invalid command.
     * @param command the operation code to determine command to execute
     */
    private void setCommand(String command) {
        switch (command) {
            case "A":
                addMember();
                break;
            case "R":
                removeMember();
                break;
            case "P":
                db.print();
                break;
            case "PC":
                db.printByCounty();
                break;
            case "PN":
                db.printByName();
                break;
            case "PD":
                db.printByExpirationDate();
                break;
            case "S":
                printFitnessClasses();
                break;
            case "C":
                checkIn();
                break;
            case "D":
                checkOut();
                break;
            case "Q":
                quitProgram();
                break;
            default:
                System.out.println(command + " is an invalid command!");
        }
    }

    /**
     * Initializes fitness classes: Pilates, Spinning, and Cardio with appropriate instructors.
     */
    private void initFitnessClasses() {
        pilates = new FitnessClass(
                FitnessClasses.Pilates.name(),
                FitnessClasses.Pilates.getInstructorName(),
                Time.PILATES
        );
        spinning = new FitnessClass(
                FitnessClasses.Spinning.name(),
                FitnessClasses.Spinning.getInstructorName(),
                Time.SPINNING
        );
        cardio = new FitnessClass(
                FitnessClasses.Cardio.name(),
                FitnessClasses.Cardio.getInstructorName(),
                Time.CARDIO
        );
    }

    /**
     * Continues reading member information from input, then calls for checks to ensure appropriate values for member
     * fields. Finally, sets values to appropriate member fields.
     */
    private void addMember() {
        Member member = new Member();
        member.setFname(st.nextToken());
        member.setLname(st.nextToken());
        member.setDob(new Date(st.nextToken()));
        member.setExpire(new Date(st.nextToken()));
        String locationName = st.nextToken();
        Location location = null;

        if (!validBirthDate(member) || !validExpirationDate(member)) return;

        switch (locationName.toUpperCase()) {
            case "BRIDGEWATER":
                location = Location.BRIDGEWATER;
                break;
            case "EDISON":
                location = Location.EDISON;
                break;
            case "PISCATAWAY":
                location = Location.PISCATAWAY;
                break;
            case "FRANKLIN":
                location = Location.FRANKLIN;
                break;
            case "SOMERVILLE":
                location = Location.SOMERVILLE;
                break;
            default:
                System.out.println(locationName + ": invalid location!");
                return;
        }
        member.setLocation(location);

        if (db.add(member)) System.out.println(member.getFname() + " " + member.getLname() + " added.");
        else System.out.println(member.getFname() + " " + member.getLname() + " is already in the database.");
    }

    /**
     * Checks if member is in database, if true then the member gets removed.
     */
    private void removeMember() {
        Member member = new Member();
        member.setFname(st.nextToken());
        member.setLname(st.nextToken());
        member.setDob(new Date(st.nextToken()));
        if (db.remove(member)) System.out.println(member.getFname() + " " + member.getLname() + " removed.");
        else System.out.println(member.getFname() + " " + member.getLname() + " is not in the database.");
    }

    /**
     * Prints out list of fitness classes, instructor name, time, and participants (if any).
     */
    private void printFitnessClasses() {
        System.out.println("\n-Fitness classes-");
        pilates.printClass();
        spinning.printClass();
        cardio.printClass();
        System.out.println();
    }

    /**
     * Checks given member information is valid, and then checks member in for desired fitness class if there are no
     * time conflicts.
     */
    private void checkIn() {
        Member memberInfo = new Member();
        String fitnessClassName = st.nextToken();
        memberInfo.setFname(st.nextToken());
        memberInfo.setLname(st.nextToken());
        memberInfo.setDob(new Date(st.nextToken()));

        if (!validBirthDate(memberInfo) || expirationDateExpired(memberInfo)
                || !db.memberExists(memberInfo) || !db.validDob(memberInfo))
            return;

        Member member = db.getMemberFromDb(memberInfo);

        switch (fitnessClassName.toUpperCase()) {
            case "PILATES":
                if (pilates.participantCheckedIn(member))
                    System.out.println(member.getFname() + " " + member.getLname() + " has already checked in Pilates.");
                else pilates.checkIn(member);
                break;
            case "SPINNING":
                if (spinning.participantCheckedIn(member))
                    System.out.println(member.getFname() + " " + member.getLname() + " has already checked in Spinning.");
                else if (cardio.participantCheckedIn(member))
                    System.out.println("Spinning time conflict -- " + member.getFname() + " "
                            + member.getLname() + " has already checked in Cardio.");
                else spinning.checkIn(member);
                break;
            case "CARDIO":
                if (cardio.participantCheckedIn(member))
                    System.out.println(member.getFname() + " " + member.getLname() + " has already checked in Cardio.");
                else if (spinning.participantCheckedIn(member))
                    System.out.println("Cardio time conflict -- " + member.getFname() + " " + member.getLname()
                            + " has already checked in Spinning.");
                else cardio.checkIn(member);
                break;
            default:
                System.out.println(fitnessClassName + " class does not exist.");
                break;
        }
    }

    /**
     * Checks if member is valid and checked into appropriate fitness class, then drops them from that fitness class.
     */
    private void checkOut() {
        Member member = new Member();
        String fitnessClassName = st.nextToken();
        member.setFname(st.nextToken());
        member.setLname(st.nextToken());
        member.setDob(new Date(st.nextToken()));

        if (!validBirthDate(member) ||  !db.validDob(member)) return;

        if (!db.memberExists(member)) {
            System.out.println(member.getFname() + " " + member.getLname()
                    + " is not a participant in " + fitnessClassName + ".");
            return;
        }

        switch (fitnessClassName) {
            case "Pilates":
                if (!pilates.participantCheckedIn(member))
                    System.out.println(member.getFname() + " " + member.getLname()
                            + " is not a participant in Pilates.");
                else pilates.checkOut(member);
                break;
            case "Spinning":
                if (!spinning.participantCheckedIn(member))
                    System.out.println(member.getFname() + " " + member.getLname()
                            + " is not a participant in Spinning.");
                else spinning.checkOut(member);
                break;
            case "Cardio":
                if (!cardio.participantCheckedIn(member))
                    System.out.println(member.getFname() + " " + member.getLname()
                            + " is not a participant in Cardio.");
                else cardio.checkOut(member);
                break;
            default:
                System.out.println(fitnessClassName + " class does not exist.");
                break;
        }
    }

    /**
     * Checks that expiration date is a valid calendar date.
     * @param member member to get expiration date from.
     * @return true if the expiration is a valid calendar date, false otherwise.
     */
    private boolean validExpirationDate(Member member) {
        if (!member.getExpire().isValid()) {
            System.out.println("Expiration date " + member.getExpire() + ": invalid calendar date!");
            return false;
        }
        return true;
    }

    /**
     * Checks that member is in database, then checks if membership is active or expired.
     * @param member member to get the expiration date from.
     * @return true if the membership is expired, false otherwise.
     */
    private boolean expirationDateExpired(Member member) {
        Date today = new Date();
        if (!db.memberExists(member)) {
            System.out.println(member.getFname() + " " + member.getLname() + " "
                    + member.getDob() + " is not in database.");
            return false;
        }
        Date expDate = db.getMemberFromDb(member).getExpire();
        if (expDate.compareTo(today) <= 0) {
            System.out.println(member.getFname() + " " + member.getLname() + " "
                    + member.getDob() + " membership expired.");
            return true;
        }
        return false;
    }

    /**
     * Checks that birthdate is a valid calendar date, is earlier than today, and is over the age of 18.
     * @param member member to get date of birth from.
     * @return true if date of birth is valid, false otherwise.
     */
    private boolean validBirthDate(Member member) {
        Date today = new Date();
        if (!member.getDob().isValid()) {
            System.out.println("DOB " + member.getDob() + ": invalid calendar date!");
            return false;
        } else if (member.getDob().compareTo(today) > 0) {
            System.out.println("DOB " + member.getDob() + ": cannot be today or a future date!");
            return false;
        } else if (!member.getDob().isOfAge()) {
            System.out.println("DOB " + member.getDob() + ": must be 18 or older to join!");
            return false;
        }
        return true;
    }

    /**
     * Terminates program.
     */
    private void quitProgram() {
        System.out.println("Gym Manager terminated.");
        System.exit(0);
    }
}
