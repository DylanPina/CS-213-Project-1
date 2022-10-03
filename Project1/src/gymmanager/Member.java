package gymmanager;

/**
 * Used to create new Member objects that hold member information. These objects can then be compared.
 * Holds member name, date of birth, membership expiration date, and their gym location.
 * @author Aaron Newland, Dylan Pina
 */
public class Member implements Comparable<Member> {
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    /**
     * Creates new Member object with null values.
     */
    public Member() {
        fname = null;
        lname = null;
        dob = null;
        expire = null;
        location = null;
    }

    /**
     * Creates new Member object with given values.
     * @param fname member first name.
     * @param lname member last name.
     * @param dob member date of birth.
     * @param expire member membership expiration date.
     * @param location member gym location.
     */
    public Member(String fname, String lname, Date dob, Date expire, Location location) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.expire = expire;
        this.location = location;
    }

    /**
     * gets member's gym location.
     * @return member's gym location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets member's gym location.
     * @param location member's gym location.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * gets member's first name.
     * @return member's first name.
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets member's first name.
     * @param fname member's first name.
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * gets member's last name.
     * @return member's last name.
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets member's last name.
     * @param lname member's last name.
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * gets member's date of birth.
     * @return member's date of birth.
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets member's date of birth.
     * @param dob member's date of birth.
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets member's membership expiration date.
     * @return member's membership expiration date.
     */
    public Date getExpire() {
        return expire;
    }

    /**
     * Sets member's membership expiration date.
     * @param expire member's membership expiration date.
     */
    public void setExpire(Date expire) {
        this.expire = expire;
    }

    /**
     * Provides a string representation of a Member object.
     * @return String of Member object.
     */
    @Override
    public String toString() {
        return fname + " " + lname + ", DOB: " + dob.toString() + ", Membership expires "
                + expire.toString() + ", " + location.toString();
    }

    /**
     * Determines if a member is equal to another member. First name, last name, and date of birth are the same.
     * @param obj Member to check if equal to another Member.
     * @return true if Member is equal to other Member, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (fname.equalsIgnoreCase(((Member) obj).getFname()) && (lname.equalsIgnoreCase(((Member) obj).getLname()) &&
                (dob.equals(((Member) obj).getDob())))) return true;
        return false;
    }

    /**
     * Compares two members to each other. M1 and M2.
     * @param member Member (M2) to compare to other Member.
     * @return 1 if M1 > M2, 0 if M1 == M2, and -1 if M1 < M2.
     */
//    @Override
//    public int compareTo(Member member){
//        return this.fname.compareTo(member.fname);
//    }
    @Override
    public int compareTo(Member member){
        if (this.lname.compareToIgnoreCase(member.lname) == 0) {
            return this.fname.compareToIgnoreCase(member.fname);
        } else return this.lname.compareToIgnoreCase(member.lname);
        //return this.fname.compareTo(member.fname);
    }

    /**
     * Testbed main. Used to test Member class in isolation.
     * @param args input used for testing Member class.
     */
    public static void main(String[] args) {

        //Test case 1
        Member m1 = new Member();
        m1.setFname("John");
        m1.setLname("Doe");

        Member m2 = new Member();
        m2.setFname("John");
        m2.setLname("Doe");

        System.out.println("Test 1");
        System.out.println("Expected result: 0");
        System.out.println(m1.compareTo(m2));

        //Test case 2
        m1.setFname("John");
        m2.setLname("Doe");

        m1.setFname("john");
        m2.setLname("doe");

        System.out.println("\nTest 2");
        System.out.println("Expected result: 0");
        System.out.println(m1.compareTo(m2));

        /*
        Member m = new Member();
        m.setFname("April");
        m.setLname("March");
        m.setDob(new Date("1/20/2004"));

        Member n = new Member();
        n.setFname("April");
        n.setLname("March");
        n.setDob(new Date("1/20/2004"));

        Member o = new Member();
        o.setFname("March");
        o.setLname("March");

        System.out.println("Comparing members: m and n");
        System.out.println("Expected Result: true");
        System.out.println("Obtained Result: " + m.equals(n));

        System.out.println("Comparing members: m and o");
        System.out.println("Expected Result: false");
        System.out.println("Obtained Result: " + m.equals(o));

        Date dob = new Date("3/31/1990");
        m.setDob(dob);
        if (m.dob.isValid()) System.out.println("Valid");
         */
    }
}
