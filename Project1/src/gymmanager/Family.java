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

    @Override
    public double membershipFee() {
        return initFee + quarterlyFee;
    }

    public int getGuestPasses() {
        return guestPasses;
    }

    public void setGuestPasses(int guestPasses) {
        this.guestPasses = guestPasses;
    }
}
