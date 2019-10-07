package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class ExpandedNumberFormTest {
    @Test
    public void testSomething() {
        assertEquals("90", ExpandedNumberForm.expandedForm(90));
        assertEquals("10 + 2", ExpandedNumberForm.expandedForm(12));
        assertEquals("40 + 2", ExpandedNumberForm.expandedForm(42));
        assertEquals("70000 + 300 + 4", ExpandedNumberForm.expandedForm(70304));
    }
}
