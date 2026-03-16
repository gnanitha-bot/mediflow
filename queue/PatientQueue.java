package queue;

import java.util.LinkedList;
import java.util.Queue;
import model.Patient;

public class PatientQueue {

    private Queue<Patient> queue = new LinkedList<>();

    // Add patient to queue
    public void addPatient(Patient p) {
        queue.add(p);
        System.out.println("Patient added to waiting queue.");
    }

    // Serve patient (remove from queue)
    public Patient servePatient() {
        if (queue.isEmpty()) {
            System.out.println("No patients in queue.");
            return null;
        }
        return queue.poll();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Display queue
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (Patient p : queue) {
                System.out.println(p);
            }
        }
    }
}