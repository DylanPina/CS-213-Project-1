package tests;

import gymmanager.Premium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumTest {

    @Test
    void test_membershipFee() {
        Premium premiumMember = new Premium();
        double expectedResult = 659.89;
        double result = premiumMember.membershipFee();
        assertEquals(expectedResult, result);
    }
}