package storage;

import java.util.HashMap;
import model.Patient;

public class PatientStore {

    private HashMap<Integer, Patient> patients = new HashMap<>();

    // Add patient
    public void addPatient(Patient p) {
        patients.put(p.getPatientId(), p);
        System.out.println("Patient added successfully.");
    }

    // Get patient by ID
    public Patient getPatient(int id) {
        return patients.get(id);
    }

    // Delete patient
    public void deletePatient(int id) {
        if (patients.containsKey(id)) {
            patients.remove(id);
            System.out.println("Patient removed.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Display all patients
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patients.values()) {
                System.out.println(p);
            }
        }
    }
}