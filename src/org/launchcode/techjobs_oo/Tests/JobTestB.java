package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTestB {
    private Job job1, job2, job3, job4, job5;

    @Before
    public void createTestJobObjects() {
        // job1 and job2 contain identical fields and values EXCEPT for id.
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        job4 = new Job("Product tester", new Employer("ACME"),
                new Location(""), new PositionType(""),
                new CoreCompetency("Persistence"));
        job5= new Job ("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job2.getId() - job1.getId());
    }

    public void testJobConstructorSetsAllFields() {
        assertTrue(job4.getName() instanceof String);
        assertEquals("Web Developer", job4.getName());
        assertTrue(job4.getEmployer() instanceof Employer);
        assertEquals("LaunchCode", job4.getEmployer().getValue());
        assertTrue(job4.getLocation() instanceof Location);
        assertEquals("StL", job4.getLocation().getValue());
        assertTrue(job4.getPositionType() instanceof PositionType);
        assertEquals("Back-end developer", job4.getPositionType().getValue());
        assertTrue(job4.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Java", job4.getCoreCompetency().getValue());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        assertTrue(job3.toString().startsWith("\n") && job3.toString().endsWith("\n"));
    }
    @Test
    public void testToStringAddsLabelForEachData() {
        assertEquals("\nID: 3\n" +
                "Name: Web Developer\n" +
                "Employer: LaunchCode\n" +
                "Location: StL\n" +
                "Position Type: Back-end developer\n" +
                "Core Competency: Java\n", job3.toString());
    }
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
