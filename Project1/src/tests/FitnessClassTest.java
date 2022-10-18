package tests;

import gymmanager.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessClassTest {

    @Test
    void checkIn_member_invalid_calendar_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Member("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = "DOB: " + member.getDob() + " invalid calendar date!";
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_invalid_calendar_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = "DOB: " + member.getDob() + " invalid calendar date!";
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_invalid_calendar_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult = "DOB: " + member.getDob() + " invalid calendar date!";
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_guest_invalid_calendar_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = "DOB: " + member.getDob() + " invalid calendar date!";
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_guest_invalid_calendar_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult = "DOB: " + member.getDob() + " invalid calendar date!";
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_member_expiration_date_expired() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Member("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        member.setExpire(new Date());
        String expectedResult = member.getFname() + " " + member.getLname() + " " + member.getDob() + " membership expired.";
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_expiration_date_expired() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        member.setExpire(new Date());
        String expectedResult = member.getFname() + " " + member.getLname() + " " + member.getDob() + " membership expired.";
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_expiration_date_expired() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        member.setExpire(new Date());
        String expectedResult = member.getFname() + " " + member.getLname() + " " + member.getDob() + " membership expired.";
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_guest_expiration_date_expired() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        member.setExpire(new Date());
        String expectedResult = member.getFname() + " " + member.getLname() + " " + member.getDob() + " membership expired.";
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_guest_expiration_date_expired() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        member.setExpire(new Date());
        String expectedResult = member.getFname() + " " + member.getLname() + " " + member.getDob() + " membership expired.";
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_member_already_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Member("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = member.getFname() + " " + member.getLname() + " already checked in.";
        fitnessClass.checkIn(member);
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_already_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = member.getFname() + " " + member.getLname() + " already checked in.";
        fitnessClass.checkIn(member);
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_already_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult = member.getFname() + " " + member.getLname() + " already checked in.";
        fitnessClass.checkIn(member);
        String result = fitnessClass.checkIn(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_guest_location_restriction() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.FRANKLIN);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = member.getFname() + " " + member.getLname() + " Guest checking in "
                + fitnessClass.getLocation().name() + ", " + fitnessClass.getLocation().getZip() + ", "
                + fitnessClass.getLocation().getCounty() + " - guest location restriction.";
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_guest_location_restriction() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.FRANKLIN);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult = member.getFname() + " " + member.getLname() + " Guest checking in "
                + fitnessClass.getLocation().name() + ", " + fitnessClass.getLocation().getZip() + ", "
                + fitnessClass.getLocation().getCounty() + " - guest location restriction.";
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_guest_no_guest_passes() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = member.getFname() + " " + member.getLname() + " ran out of guest pass.";
        fitnessClass.checkInGuest(member);
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_guest_no_guest_passes() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult = member.getFname() + " " + member.getLname() + " ran out of guest pass.";
        fitnessClass.checkInGuest(member);
        fitnessClass.checkInGuest(member);
        fitnessClass.checkInGuest(member);
        String result = fitnessClass.checkInGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_member_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String result = fitnessClass.checkIn(member);
        String expectedResult = member.getFname() + " " + member.getLname() + " checked in " + fitnessClass + "\n";
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_family_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String result = fitnessClass.checkIn(member);
        String expectedResult = member.getFname() + " " + member.getLname() + " checked in " + fitnessClass + "\n";
        assertEquals(expectedResult, result);
    }

    @Test
    void checkIn_premium_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String result = fitnessClass.checkIn(member);
        String expectedResult = member.getFname() + " " + member.getLname() + " checked in " + fitnessClass + "\n";
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_member_invalid_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Member("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult =  "DOB " + member.getDob() + ": invalid calendar date!";
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_family_invalid_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult =  "DOB " + member.getDob() + ": invalid calendar date!";
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_premium_invalid_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult =  "DOB " + member.getDob() + ": invalid calendar date!";
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_member_not_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Member("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult =  member.getFname() + " " + member.getLname() + " did not check in.";
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_family_not_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult =  member.getFname() + " " + member.getLname() + " did not check in.";
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_premium_not_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult =  member.getFname() + " " + member.getLname() + " did not check in.";
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_member_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Member("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = member.getFname() + " " + member.getLname() + " done with the class.";
        fitnessClass.checkIn(member);
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_family_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult = member.getFname() + " " + member.getLname() + " done with the class.";
        fitnessClass.checkIn(member);
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_premium_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult = member.getFname() + " " + member.getLname() + " done with the class.";
        fitnessClass.checkIn(member);
        String result = fitnessClass.checkout(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_family_guest_invalid_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult =  "DOB " + member.getDob() + ": invalid calendar date!";
        String result = fitnessClass.checkoutGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_premium_guest_invalid_date() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/34/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult =  "DOB " + member.getDob() + ": invalid calendar date!";
        String result = fitnessClass.checkoutGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_family_guest_not_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult =  member.getFname() + " " + member.getLname() + " Guest did not check in.";
        String result = fitnessClass.checkoutGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_premium_guest_not_checked_in() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult =  member.getFname() + " " + member.getLname() + " Guest did not check in.";
        String result = fitnessClass.checkoutGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_family_guest_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Family("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addThreeMonths());
        String expectedResult =  member.getFname() + " " + member.getLname() + " Guest done with the class.";
        String result = fitnessClass.checkoutGuest(member);
        assertEquals(expectedResult, result);
    }

    @Test
    void checkOut_premium_guest_success() {
        FitnessClass fitnessClass = new FitnessClass("PILATES", "Becky", Location.BRIDGEWATER);
        Member member = new Premium("Dylan", "Pina", new Date("8/24/2001"), Location.BRIDGEWATER);
        Date today = new Date();
        member.setExpire(today.addOneYear());
        String expectedResult =  member.getFname() + " " + member.getLname() + " Guest done with the class.";
        String result = fitnessClass.checkoutGuest(member);
        assertEquals(expectedResult, result);
    }
}