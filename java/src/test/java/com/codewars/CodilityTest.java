package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CodilityTest {
    @Test
    public void example() {
        assertEquals(5, codility.solution(new int[] {1, 3, 6, 4, 1, 2}));
        assertEquals(4, codility.solution(new int[] {1, 2, 3}));
        assertEquals(1, codility.solution(new int[] {-1, -3}));
    }

}
