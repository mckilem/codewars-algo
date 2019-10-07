package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class NextBiggerTest {
    @Test
    public void basicTests() {
        assertEquals(21, NextBiggerWithSameDigits.nextBiggerNumber(12));
        assertEquals(531, NextBiggerWithSameDigits.nextBiggerNumber(513));
        assertEquals(2071, NextBiggerWithSameDigits.nextBiggerNumber(2017));
        assertEquals(441, NextBiggerWithSameDigits.nextBiggerNumber(414));
        assertEquals(414, NextBiggerWithSameDigits.nextBiggerNumber(144));
    }
}
