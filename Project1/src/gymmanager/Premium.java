package gymmanager;

public class Premium extends Family implements Comparable<Member> {
    private final double premiumFee = 659.89;

    public Premium() {
        super();
        setGuestPasses(3);
    }

    public Premium(String fname, String lname, Date dob, Location location) {
        super(fname, lname, dob, location);
        setGuestPasses(3);
    }

    public Premium(String fname, String lname, Date dob, Date expire, Location location) {
        super(fname, lname, dob, expire, location);
        setGuestPasses(3);
    }

    @Override
    public double membershipFee() {
        return premiumFee;
    }

    @Override
    public String toString() {
        return getFname() + " " + getLname() + ", DOB: " + getDob().toString() + ", Membership expires "
                + getExpire().toString() + ", " + getLocation().toString() + ", (Premium) Guest-pass remaining: "
                + getGuestPasses();
    }
}
