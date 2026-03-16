package model;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private int severity;

    public Patient(int patientId, String name, int age, int severity) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.severity = severity;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Name: " + name +
               ", Age: " + age +
               ", Severity: " + severity;
    }
}