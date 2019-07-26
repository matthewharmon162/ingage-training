package com.seleniumsimplified.junit;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;



import static org.junit.Assert.*;

public class JUnitExampleTest {

    private String iSetThisBefore ="set as field";
    private static String iSetThisBeforeClass = "default";

    @Test
    public void twoPlusTwoEqualsFour() {
        assertEquals("2+2=4", 4, 2 + 2);

    }

    @Test
    public void usingAssertTrue() {
        assertTrue("true is true", true);
        assertTrue("3+3 =6 ", (3 + 3) == 6);
        String theAnswer = "The Answer";
        assertTrue("The answer is true", "the answer".equalsIgnoreCase(theAnswer));
    }

    @Test
    public void usingAssertFalse() {
        assertFalse("false is not true", false);
        assertFalse("I always forget half of seven ", (7 / 2) == 4);
        String anAnswer = "An Answer";
        assertFalse("An Answer does not contain The Answer", anAnswer.contains("The"));
    }

    @Before
    public void setSomethingBeforeToUseLater(){
        iSetThisBefore = "set before";
    }

    @Test
    public void checkISetSomethingBefore(){
        assertFalse("isSetThisBefore Should not equal default value", "set as field".equals(iSetThisBefore));
        assertEquals("iSetThisBefore Should have changed", "set before", iSetThisBefore);

    }

    @BeforeClass
    public static void setSomethingBeforeClass(){
        iSetThisBeforeClass = "for all class methods";
    }

    @Test
    public void checkBeforeClassRan(){
        assertFalse("isSetThisBefore Should not equal default value", "default".equals(iSetThisBeforeClass));
        assertEquals("iSetThisBefore Should have changed", "for all class methods", iSetThisBeforeClass);
    }

    @Test
    public void assertThatBonusQuestion(){
        assertThat("The Answer", is(not("An Answer")));
        assertThat("The Answer", is(not(nullValue())));

        assertThat("The Answer", both(containsString("The")).and(containsString("Answer")));

    }
}
