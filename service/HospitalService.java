package service;

import java.util.Stack;

import model.Patient;
import storage.PatientStore;
import queue.PatientQueue;
import queue.EmergencyQueue;
import queue.DoctorRotation;

public class HospitalService {

    private PatientStore store = new PatientStore();
    private PatientQueue normalQueue = new PatientQueue();
    private EmergencyQueue emergencyQueue = new EmergencyQueue();
    private DoctorRotation doctorRotation = new DoctorRotation();

    private Stack<String> actions = new Stack<>();

    // Register patient
    public void registerPatient(Patient patient) {

        store.addPatient(patient);
        actions.push("Registered patient ID: " + patient.getPatientId());

    }

    // Book normal appointment
    public void bookAppointment(Patient patient) {

        normalQueue.addPatient(patient);
        actions.push("Appointment booked for patient ID: " + patient.getPatientId());

    }

    // Emergency admission
    public void emergencyAdmission(Patient patient) {

        emergencyQueue.addEmergencyPatient(patient);
        actions.push("Emergency admission for patient ID: " + patient.getPatientId());

    }

    // Treat normal patient
    public void treatNormalPatient() {

        Patient p = normalQueue.servePatient();

        if (p != null) {

            System.out.println("Doctor " + doctorRotation.getCurrentDoctor() + " treating: " + p);

            doctorRotation.nextDoctor();

            actions.push("Normal patient treated ID: " + p.getPatientId());

        }

    }

    // Treat emergency patient
    public void treatEmergencyPatient() {

        Patient p = emergencyQueue.treatEmergencyPatient();

        if (p != null) {

            System.out.println("Doctor " + doctorRotation.getCurrentDoctor() + " treating emergency: " + p);

            doctorRotation.nextDoctor();

            actions.push("Emergency patient treated ID: " + p.getPatientId());

        }

    }

    // Show patients
    public void showPatients() {

        store.displayAllPatients();

    }

    // Undo last action
    public void undoLastAction() {

        if (actions.isEmpty()) {

            System.out.println("No actions to undo");

        } 
        else {

            String lastAction = actions.pop();
            System.out.println("Undo operation: " + lastAction);

        }

    }
}