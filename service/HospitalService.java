package service;

import model.Patient;
import queue.PatientQueue;
import queue.EmergencyQueue;
import queue.DoctorRotation;
import storage.PatientStore;
import icu.ICUBedManager;

import java.util.Stack;

public class HospitalService {

    private PatientStore patientStore = new PatientStore();
    private PatientQueue patientQueue = new PatientQueue();
    private EmergencyQueue emergencyQueue = new EmergencyQueue();
    private DoctorRotation doctorRotation = new DoctorRotation();
    private ICUBedManager icuManager = new ICUBedManager();

    private Stack<String> undoStack = new Stack<>();


    public void registerPatient(Patient p) {

        patientStore.addPatient(p);

        undoStack.push("Registered patient ID: " + p.getId());
    }


    public void bookAppointment(Patient p) {

        patientQueue.addPatient(p);

        undoStack.push("Appointment booked for patient ID: " + p.getId());
    }


    public void emergencyAdmission(Patient p) {

        emergencyQueue.addPatient(p);

        undoStack.push("Emergency admission for patient ID: " + p.getId());
    }


    public void treatNormalPatient() {

        Patient p = patientQueue.treatPatient();

        if (p != null) {

            System.out.println("Doctor " + doctorRotation.getCurrentDoctor()
                    + " treating normal patient: " + p);

            doctorRotation.nextDoctor();
        }
    }


    public void treatEmergencyPatient() {

        // CHANGE HERE
        Patient p = emergencyQueue.treatPatient();

        if (p != null) {

            System.out.println("Doctor " + doctorRotation.getCurrentDoctor()
                    + " treating emergency patient: " + p);

            if (p.getSeverity() >= 4) {

                icuManager.allocateBed(p);
            }

            doctorRotation.nextDoctor();
        }
    }


    public void showPatients() {

        patientStore.showPatients();
    }


    public void undoLastAction() {

        if (!undoStack.isEmpty()) {

            System.out.println("Undo operation: " + undoStack.pop());

        } else {

            System.out.println("Nothing to undo.");
        }
    }


    public void showICUBeds() {

        icuManager.showBeds();
    }
}
