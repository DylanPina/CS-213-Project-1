package tests;

import gymmanager.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @org.junit.jupiter.api.Test
    void test_date_isValid() {
        Date d1 = new Date("2/29/2018");
        assertFalse(d1.isValid());

        Date d2 = new Date("2/29/2020");
        assertTrue(d2.isValid());

        Date d3 = new Date("0/1/2022");
        assertFalse(d3.isValid());

        Date d4 = new Date("-1/1/2022");
        assertFalse(d4.isValid());

        Date d5 = new Date("13/1/2022");
        assertFalse(d5.isValid());

        Date d6 = new Date("1/0/2022");
        assertFalse(d6.isValid());

        Date d7 = new Date("1/32/2022");
        assertFalse(d7.isValid());

        Date d8 = new Date("3/32/2022");
        assertFalse(d8.isValid());

        Date d9 = new Date("4/32/2022");
        assertFalse(d9.isValid());

        Date d10 = new Date("7/32/2022");
        assertFalse(d10.isValid());

        Date d11 = new Date("8/32/2022");
        assertFalse(d11.isValid());

        Date d12 = new Date("10/32/2022");
        assertFalse(d12.isValid());

        Date d13 = new Date("12/32/2022");
        assertFalse(d13.isValid());

        Date d14 = new Date("4/31/2022");
        assertFalse(d14.isValid());

        Date d15 = new Date("6/31/2022");
        assertFalse(d15.isValid());

        Date d16 = new Date("9/31/2022");
        assertFalse(d16.isValid());

        Date d17 = new Date("11/31/2022");
        assertFalse(d17.isValid());
    }
}