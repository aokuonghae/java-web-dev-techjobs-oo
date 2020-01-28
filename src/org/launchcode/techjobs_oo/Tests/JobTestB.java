package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JobTestB {
    private Job job1, job2, job3, job4, job5;

    @Before
    public void createTestJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        job4 = new Job("Product tester", new Employer("ACME"),new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
        job5= new Job ("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job2.getId() - job1.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
//        assertTrue(job3.getName() instanceof String);
        assertEquals("Web Developer", job3.getName());
//        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals("LaunchCode", job3.getEmployer().getValue());
//        assertTrue(job3.getLocation() instanceof Location);
        assertEquals("StL", job3.getLocation().getValue());
//        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals("Back-end developer", job3.getPositionType().getValue());
//        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Java", job3.getCoreCompetency().getValue());
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",job3.getId(), job3.getName(), job3.getEmployer(), job3.getLocation(),
                job3.getPositionType(), job3.getCoreCompetency());
        assertEquals(output, job3.toString());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        assertTrue(job3.toString().startsWith("\n") && job3.toString().endsWith("\n"));
    }
//    @Test
//    public void testToStringAddsLabelForEachData() {
//        assertEquals("\nID: 4\n" +
//                "Name: Web Developer\n" +
//                "Employer: LaunchCode\n" +
//                "Location: StL\n" +
//                "Position Type: Back-end developer\n" +
//                "Core Competency: Java\n", job4.toString());
//    }
    @Test
    public void testToStringPrintsDataUnavailableWhenFieldIsEmpty(){
        assertEquals("\nID: 4\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Persistence\n", job4.toString());
    }
    @Test
    public void testToStringReturnsJobNotAvailableIfOnlyIdIsFilled(){
        assertEquals("OOPS! This job does not seem to exist.", job5.toString());
    }
}