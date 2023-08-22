package model;

public class Patient implements Comparable<Patient>{
    private String name;
    private SeverityLevel severityLevel;

    public Patient(String name, SeverityLevel severityLevel) {
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public String getName() {
        return name;
    }

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }

    @Override
    public int compareTo(Patient othetPatient) {
        return this.severityLevel.compareTo(othetPatient.severityLevel);
    }
}
