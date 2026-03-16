package queue;

public class DoctorRotation {

    private String[] doctors = {"Dr.Ravi", "Dr.Sita", "Dr.Kiran", "Dr.Ajay"};
    private int index = 0;

    // Get current doctor
    public String getCurrentDoctor() {
        return doctors[index];
    }

    // Rotate to next doctor
    public void nextDoctor() {
        index = (index + 1) % doctors.length;
        System.out.println("Next doctor on duty: " + doctors[index]);
    }

    // Display all doctors
    public void displayDoctors() {
        System.out.println("Doctor Rotation List:");

        for (String doctor : doctors) {
            System.out.println(doctor);
        }
    }
}