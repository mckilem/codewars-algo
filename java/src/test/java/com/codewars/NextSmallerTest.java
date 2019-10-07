package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class NextSmallerTest {

    @Test
    public void basicTests() {
        assertEquals(12, NextSmallerWithSameDigits.nextSmaller(21));
        assertEquals(790, NextSmallerWithSameDigits.nextSmaller(907));
        assertEquals(513, NextSmallerWithSameDigits.nextSmaller(531));
        assertEquals(-1, NextSmallerWithSameDigits.nextSmaller(1027));
        assertEquals(414, NextSmallerWithSameDigits.nextSmaller(441));
        assertEquals(123456789, NextSmallerWithSameDigits.nextSmaller(123456798));
        assertEquals(1234567918, NextSmallerWithSameDigits.nextSmaller(1234567981));
    }
}