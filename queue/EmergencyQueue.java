package queue;

import java.util.PriorityQueue;
import model.Patient;

public class EmergencyQueue {

    private PriorityQueue<Patient> emergencyPatients;

    public EmergencyQueue() {

        emergencyPatients = new PriorityQueue<>(
            (p1, p2) -> p2.getSeverity() - p1.getSeverity()
        );

    }

    // Add emergency patient
    public void addEmergencyPatient(Patient patient) {

        emergencyPatients.add(patient);
        System.out.println("Emergency patient added to queue");

    }

    // Treat emergency patient
    public Patient treatEmergencyPatient() {

        if (emergencyPatients.isEmpty()) {

            System.out.println("No emergency patients");
            return null;

        }

        return emergencyPatients.poll();

    }

    // Display emergency queue
    public void displayEmergencyQueue() {

        if (emergencyPatients.isEmpty()) {

            System.out.println("No emergency patients in queue");

        } 
        else {

            for (Patient p : emergencyPatients) {

                System.out.println(p);

            }

        }

    }

}