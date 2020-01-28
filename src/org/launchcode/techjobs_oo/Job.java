package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job(){
        this.id=nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name=name;
        this.employer=employer;
        this.location=location;
        this.positionType=positionType;
        this.coreCompetency=coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
 public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        int counter=0;
        if (positionType.getValue().equals("") || positionType.getValue() == null){
            this.positionType.setValue("Data not available");
            counter+=1;
        }
        if (employer.getValue().equals("") || employer.getValue()==null){
            this.employer.setValue("Data not available");
            counter+=1;
        }
        if (location.getValue().equals("") || employer.getValue()==null){
            this.location.setValue("Data not available");
            counter+=1;
        }
        if (coreCompetency.getValue().equals("") || coreCompetency.getValue()==null){
            this.location.setValue("Data not available");
            counter+=1;
        }
        if (this.name.equals("")){
            this.name="Data not available";
            counter +=1;
        }
        if (counter==5){
            return "OOPS! This job does not seem to exist.";
        } else {
//            return  "\nID: " + this.id + "\n"+
//                    "Name: " + this.name +  "\n"+
//                    "Employer: " + this.employer + "\n"+
//                    "Location: " + this.location + "\n"+
//                    "Position Type: " + this.positionType + "\n"+
//                    "Core Competency: " + this.coreCompetency + "\n";
            return String.format("\nID: %d\n" +
                    "Name: %s\n" +
                    "Employer: %s\n" +
                    "Location: %s\n" +
                    "Position Type: %s\n" +
                    "Core Competency: %s\n", id, name, employer, location, positionType, coreCompetency);
        }

    }
}
