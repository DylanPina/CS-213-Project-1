package gymmanager;

public class Premium extends Family implements Comparable<Member> {
    private int guestPasses;

    private final double premiumFee = 659.89;

    @Override
    public double membershipFee() {
        return premiumFee;
    }

    public Premium() {
        super();
        guestPasses = 3;
    }

    public Premium(String fname, String lname, Date dob, Location location) {
        super(fname, lname, dob, location);
        guestPasses = 3;
    }

    public Premium(String fname, String lname, Date dob, Date expire, Location location) {
        super(fname, lname, dob, expire, location);
        guestPasses = 3;
    }
}
