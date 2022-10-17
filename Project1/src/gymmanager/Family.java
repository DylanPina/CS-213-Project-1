package gymmanager;

public class Family extends Member implements Comparable<Member> {
    private int guestPasses;

    private final double initFee = 29.99;
    private final double monthlyFee = 59.99;
    private final double quarterlyFee = monthlyFee * 3;

    public Family() {
        super();
        guestPasses = 1;
    }

    public Family(String fname, String lname, Date dob, Location location) {
        super(fname, lname, dob, location);
        guestPasses = 1;
    }

    public Family(String fname, String lname, Date dob, Date expire, Location location) {
        super(fname, lname, dob, expire, location);
        guestPasses = 1;
    }

    public int getGuestPasses() {
        return guestPasses;
    }

    public void setGuestPasses(int guestPasses) {
        this.guestPasses = guestPasses;
    }

    public void incrementGuessPass() {
        guestPasses++;
    }

    public void decrementGuessPass() {
        guestPasses--;
    }

    public boolean hasGuestPass() {
        return guestPasses != 0;
    }

    @Override
    public double membershipFee() {
        return initFee + quarterlyFee;
    }

    @Override
    public String toString() {
        return getFname() + " " + getLname() + ", DOB: " + getDob().toString() + ", Membership expires "
                + getExpire().toString() + ", " + getLocation().toString() + ", (Family) Guest-pass remaining: "
                + getGuestPasses();
    }
}
