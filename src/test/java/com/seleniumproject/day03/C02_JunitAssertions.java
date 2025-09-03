package com.seleniumproject.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C02_JunitAssertions {

    @Test
    public void assertionTest(){

        /*
         What is Assertion in software testing?

         - Assertion is very important step in testing. Without assertion, testing is not considered complete.
         - Assertion means to validate the expected results
         - There are many methods of assertions:
            1. assert equal => expected = actual
            2. assert true => looking for true value
            3. assert false => looking for false value
            4. assert null => looking for null value
            .........

            There are two types of assertions:
            1. Hard Assertion - if assertion fails at ANY point in the code, Java stops there.
                                It does NOT proceed any further.
            2. Soft Assertion - Will learn later
         */

        Assertions.assertEquals(5, 5); // Pass

        Assertions.assertNotEquals(4 , 7); // Pass

        Assertions.assertEquals("apple", "Apple".toLowerCase()); // pass

        Assertions.assertTrue(10 > 6);

        // Assertions.assertTrue(7 < 3); // Fail, if hard assertion fails at ANY point in the code, Java stops there.
                                              // It does NOT proceed any further.

        // Assertions.assertFalse( 7 < 11); // Fails => 7 IS less than 11 .. it is a true statement
                                                // But we are asking Java to prove that it is false .. hence fails

        Assertions.assertNull(null); // Pass
        Assertions.assertNull(" "); // Fail
        Assertions.assertNull(""); // Fail
        // HW : Why the above two assertions fail?

    }
}
