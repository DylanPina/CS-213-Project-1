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
                year % DateConstants.QUATERCENTENNIAL == 0) return true;
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
        System.out.println((c.get(Calendar.YEAR)));
        System.out.println((c.get(Calendar.MONTH) + 1));
        System.out.println((c.get(Calendar.DATE)));
        Date d = new Date();
        Date dd = new Date("3/31/1990");
        Date ddd = new Date("3/31/1990");
        Date yesterday = new Date("9/21/2022");
        Date today = new Date();
        Date today2 = new Date();
        Date future = new Date("12/2/2022");

        System.out.println("-Add dates-");
        System.out.println("Date added: " + d.month + "/" + d.day + "/" + d.year);
        System.out.println("Date added: " + dd.month + "/" + dd.day + "/" + dd.year);
        System.out.println("Date added: " + ddd.month + "/" + ddd.day + "/" + ddd.year);

        System.out.println("\n-Comparing dates-");
        System.out.println("Expected result: 1");
        System.out.println("Obtained result: " + d.compareTo(dd));
        System.out.println("Expected result: 0");
        System.out.println("Obtained result: " + dd.compareTo(ddd));
        System.out.println("Expected result: 0");
        System.out.println("Obtained result: " + today.compareTo(today2));
        System.out.println("Expected result: 1");
        System.out.println("Obtained result: " + today.compareTo(yesterday));
        System.out.println("Expected result: -1");
        System.out.println("Obtained result: " + today.compareTo(future));

        System.out.println("\n-Check for valid dates-");
        Date dates[] = new Date[8];
        dates[0] = new Date("2/29/2003");
        dates[1] = new Date("4/31/2003");
        dates[2] = new Date("13/31/2003");
        dates[3] = new Date("3/32/2003");
        dates[4] = new Date("-1/31/2003");
        dates[5] = new Date("4/31/2022");
        dates[6] = new Date("2/30/2011");
        dates[7] = new Date("4/3/2003");
        for (Date da : dates)
            if (da.isValid()) System.out.println(da + ": Valid date");
            else System.out.println(da + ": Invalid date");

        System.out.println("\n-Check for valid DOB-");
        System.out.println("Expected result: true");
        System.out.println("Obtained result: " + yesterday.isValidDob());
        System.out.println("Expected result: true");
        System.out.println("Obtained result: " + today.isValidDob());
        System.out.println("Expected result: false");
        System.out.println("Expected result: " + future.isValidDob());
    }
}
