package gymmanager;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Used to create new Date objects that can be compared. Used for date of birth and membership expiration date.
 * Contains methods used to test validity of given dates, and to determine if given year is a leap year and if an
 * individual is over the age of 18 (able to hold a gym membership).
 * @author Aaron Newland, Dylan Pina
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * Creates Date object with today's date.
     */
    public Date() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DATE);
    }

    /**
     * Creates Date object with given String date.
     * @param date date given as string is parsed into Date object.
     */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date);
        month = Integer.parseInt(st.nextToken("/"));
        day = Integer.parseInt(st.nextToken("/"));
        year = Integer.parseInt(st.nextToken("/"));
    }

    /**
     * Retrieve Year field.
     * @return year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Retrieve Month field.
     * @return month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Retrieve Day field.
     * @return day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Determines if given year is a leap year.
     * @return true if it is a leap year, false otherwise.
     */
    private boolean isLeapYear() {
        if (year % DateConstants.QUADRENNIAL == 0 && year % DateConstants.CENTENNIAL == 0 &&
                year % DateConstants.QUATERCENTENNIAL == 0) {
            return true;
        } else if (year % DateConstants.QUADRENNIAL == 0 && year % DateConstants.CENTENNIAL != 0) return true;

        return false;
    }

    /**
     * Determines if two dates are equal to one another. Year, month, and day are the same for both.
     * @param date date to compare to given date
     * @return true if dates are the same, false otherwise.
     */
    public boolean equals(Date date) {
        return compareTo(date) == 0;
    }

    /**
     * Compares dates to one another. D1 and D2.
     * @param date date (D2) to compare to given date.
     * @return 0 if D1 == D2, 1 if D1 > D2, and -1 if D1 < D2.
     */
    @Override
    public int compareTo(Date date) {
        if (date.year == year && date.month == month && date.day == day) return 0;

        if (date.year == year && date.month == month)
            if (date.day < day) return 1;
            else return -1;

        if (date.year == year && date.month < month) return 1;
        else if (date.year == year && date.month > month) return -1;

        if (date.year < year) return 1;
        else return -1;
    }

    /**
     * Check if a date is a valid calendar date.
     * @return true if calendar date is valid, false otherwise.
     */
    public boolean isValid() {
        if (day < 1) return false;
        // Months that have 31 days
        if ((month == DateConstants.JAN) || (month == DateConstants.MAR) || (month == DateConstants.MAY)
                || (month == DateConstants.JUL) || (month == DateConstants.AUG)
                || (month == DateConstants.OCT) || (month == DateConstants.DEC)) {
            if (day <= DateConstants.MAX_DAYS_1)
                return true;
            // Months that have 30 days
        } else if ((month == DateConstants.APR) || (month == DateConstants.JUN) ||
                (month == DateConstants.SEP) || (month == DateConstants.NOV)) {
            if (day <= DateConstants.MAX_DAYS_2)
                return true;
            // February case
        } else if (month == DateConstants.FEB) {
            if (isLeapYear())
                if (day <= DateConstants.MAX_DAYS_LEAP)
                    return true;
                else if (day <= DateConstants.MAX_DAYS_NO_LEAP)
                    return true;
        }
        return false;
    }

    /**
     * Determines if date of birth is over the age of 18.
     * @return true if date of birth is over the age of 18, false otherwise.
     */
    public boolean isOfAge() {
        Calendar c = Calendar.getInstance();
        int currYear = c.get(Calendar.YEAR);
        int currMonth = c.get(Calendar.MONTH) + 1;
        int currDay = c.get(Calendar.DATE);

        if (currYear - year > DateConstants.LEGAL_AGE)
            return true;
        if (currYear - year == DateConstants.LEGAL_AGE)
            if (currMonth > month)
                return true;
            else if (currMonth == month)
                if (currDay >= day)
                    return true;
        return false;
    }

    /**
     * Determines if date of birth is before the date of today, and valid.
     * @return true if date given is before today's date, false otherwise.
     */
    public boolean isValidDob() {
        Date today = new Date();
        if (today.getYear() < year) return false;
        else if (today.getYear() == year)
            if (today.getMonth() < month)
                return false;
            else if (today.getMonth() == month)
                if (today.getDay() < day)
                    return false;
        return true;
    }

    /**
     * Provides a string representation of a Date object.
     * @return String of date object.
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Testbed main. Used to test Date class in isolation.
     * @param args input used for testing Date class.
     */
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        // Test case 1
        Date d1 = new Date("2/29/2018");
        System.out.println("Test 1");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d1.isValid());

        // Test case 2
        Date d2 = new Date("2/29/2020");
        System.out.println("\nTest 2");
        System.out.println("Expected output: true");
        System.out.println("Obtained output: " + d2.isValid());

        // Test case 3
        Date d3 = new Date("0/1/2022");
        System.out.println("\nTest 3");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d3.isValid());

        // Test case 4
        Date d4 = new Date("-1/1/2022");
        System.out.println("\nTest 4");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d4.isValid());

        // Test case 5
        Date d5 = new Date("13/1/2022");
        System.out.println("\nTest 5");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d5.isValid());

        // Test case 6
        Date d6 = new Date("1/0/2022");
        System.out.println("\nTest 6");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d6.isValid());

        // Test case 7
        Date d7 = new Date("1/32/2022");
        System.out.println("\nTest 7");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d7.isValid());

        // Test case 8
        Date d8 = new Date("3/32/2022");
        System.out.println("\nTest 8");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d8.isValid());

        // Test case 9
        Date d9 = new Date("4/32/2022");
        System.out.println("\nTest 9");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d9.isValid());

        // Test case 10
        Date d10 = new Date("7/32/2022");
        System.out.println("\nTest 10");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d10.isValid());

        // Test case 11
        Date d11 = new Date("8/32/2022");
        System.out.println("\nTest 11");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d11.isValid());

        // Test case 12
        Date d12 = new Date("10/32/2022");
        System.out.println("\nTest 12");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d12.isValid());

        // Test case 13
        Date d13 = new Date("12/32/2022");
        System.out.println("\nTest 13");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d13.isValid());

        // Test case 14
        Date d14 = new Date("4/31/2022");
        System.out.println("\nTest 14");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d14.isValid());

        // Test case 15
        Date d15 = new Date("6/31/2022");
        System.out.println("\nTest 15");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d15.isValid());

        // Test case 16
        Date d16 = new Date("9/31/2022");
        System.out.println("\nTest 16");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d16.isValid());

        // Test case 17
        Date d17 = new Date("11/31/2022");
        System.out.println("\nTest 17");
        System.out.println("Expected output: false");
        System.out.println("Obtained output: " + d17.isValid());
    }
}
