package main;

import java.util.Scanner;

import model.Patient;
import service.HospitalService;

public class MediFlow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalService hospital = new HospitalService();

        int choice;

        do {

            System.out.println("\n===== MediFlow Hospital System =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Book Appointment");
            System.out.println("3. Emergency (108)");
            System.out.println("4. Treat Normal Patient");
            System.out.println("5. Treat Emergency Patient");
            System.out.println("6. Show All Patients");
            System.out.println("7. Undo Last Action");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Severity (1-5): ");
                    int severity = sc.nextInt();

                    Patient p = new Patient(id, name, age, severity);

                    hospital.registerPatient(p);

                    break;

                case 2:

                    System.out.print("Enter Patient ID: ");
                    int id2 = sc.nextInt();

                    System.out.print("Enter Age: ");
                    int age2 = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();

                    System.out.print("Enter Severity (1-5): ");
                    int sev2 = sc.nextInt();

                    Patient normalPatient = new Patient(id2, name2, age2, sev2);

                    hospital.bookAppointment(normalPatient);

                    break;

                case 3:

                    System.out.print("Enter Patient ID: ");
                    int id3 = sc.nextInt();

                    System.out.print("Enter Age: ");
                    int age3 = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name3 = sc.nextLine();

                    System.out.print("Enter Severity (1-5): ");
                    int sev3 = sc.nextInt();

                    Patient emergencyPatient = new Patient(id3, name3, age3, sev3);

                    hospital.emergencyAdmission(emergencyPatient);

                    break;

                case 4:

                    hospital.treatNormalPatient();

                    break;

                case 5:

                    hospital.treatEmergencyPatient();

                    break;

                case 6:

                    hospital.showPatients();

                    break;

                case 7:

                    hospital.undoLastAction();

                    break;

                case 8:

                    System.out.println("Exiting system...");

                    break;

                default:

                    System.out.println("Invalid choice");

            }

        } while (choice != 8);

        sc.close();
    }
}