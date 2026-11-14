/**
 * AssignmentOne class
 * Main entry point of the appointment management system
 * Create health professional objects, run demonstration test‑cases, interactive menu (teacher extra requirement)
 * All core assessment requirements are demonstrated by pre‑scripted code before entering menu
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentManager manager = new AppointmentManager();

        // Create six different health professional objects (numeric ID only)
        HealthProfessional gp = new GeneralPractitioner(1001, "Dr Charlie", "Mon‑Fri", "Community Clinic");
        HealthProfessional surgeon = new Surgeon(1002, "Dr Alex", "Tue,Thu", "Surgery");
        HealthProfessional nurse = new Nurse(1003, "Bob", "Mon‑Fri", "General Ward");
        HealthProfessional dietitian = new Dietitian(1004, "Luna", "Mon,Wed,Fri", "Nutrition");
        HealthProfessional paediatrician = new Pediatrician(1005, "Zoe", "Tue,Wed", "Children Clinic");
        HealthProfessional physio = new Physiotherapist(1006, "Max", "Mon‑Thu", "Rehabilitation");

        // Part3: print all health professionals details
        System.out.println("===== All Health Professionals =====");
        gp.printInfo();
        surgeon.printInfo();
        nurse.printInfo();
        dietitian.printInfo();
        paediatrician.printInfo();
        physio.printInfo();
        System.out.println();

        // Create appointment objects
        System.out.println("===== Add valid appointments =====");
        Appointment a1 = new Appointment("Tom", "0400111222", gp, "2026‑11‑16", "09:00");
        Appointment a2 = new Appointment("Lily", "0400333444", surgeon, "2026‑11‑16", "10:30");
        Appointment a3 = new Appointment("Jack", "0400555666", nurse, "2026‑11‑16", "14:00");
        manager.addAppointment(a1);
        manager.addAppointment(a2);
        manager.addAppointment(a3);
        System.out.println();

        // Test duplicate booking error case
        System.out.println("===== Test duplicate booking =====");
        Appointment duplicate = new Appointment("Amy", "0400999888", gp, "2026‑11‑16", "09:00");
        manager.addAppointment(duplicate);
        System.out.println();

        // Test invalid time error case
        System.out.println("===== Test invalid time =====");
        Appointment badTime = new Appointment("Ben", "0400777666", gp, "2026‑11‑16", "17:00");
        manager.addAppointment(badTime);
        System.out.println();

        // Sort demonstration
        System.out.println("===== Before sort =====");
        manager.printAllAppointments();
        manager.sortAppointments();
        System.out.println("===== After sort =====");
        manager.printAllAppointments();
        System.out.println();

        // Filter by doctor id
        System.out.println("===== Filter doctor ID 1001 appointments =====");
        ArrayList<Appointment> gpList = manager.filterByDoctorId(1001);
        for(Appointment app : gpList){
            System.out.println(app);
        }
        System.out.println();

        // Filter by patient phone (new required function)
        System.out.println("===== Filter appointments by patient phone 0400111222 =====");
        ArrayList<Appointment> phoneFilterList = manager.filterByPatientPhone("0400111222");
        for(Appointment app : phoneFilterList){
            System.out.println(app);
        }
        System.out.println();

        // Cancel version‑1: by patient name+date+time
        System.out.println("===== Cancel non‑existent appointment (patient name mode) =====");
        manager.cancelAppointment("NullMan", "2026‑11‑16", "08:30");
        System.out.println();

        // Cancel version‑2: by doctor id + date + time (overload required by brief)
        System.out.println("===== Cancel appointment by doctor ID 1002, date 2026‑11‑16, time 10:30 =====");
        manager.cancelAppointment(1002,"2026‑11‑16","10:30");
        System.out.println("===== List after doctor‑id based cancel =====");
        manager.printAllAppointments();
        System.out.println();

        System.out.println("===== Final appointment list before interactive menu =====");
        manager.printAllAppointments();
        System.out.println();

        // Interactive menu (teacher extra requirement, not core brief requirement)
        while(true) {
            System.out.println("========== PATIENT MENU ==========");
            System.out.println("1. Add new appointment");
            System.out.println("2. Cancel appointment (patient name mode)");
            System.out.println("3. Modify appointment time");
            System.out.println("4. Show all appointments");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            if(opt == 1) {
                System.out.print("Patient name: ");
                String pName = sc.nextLine();
                System.out.print("Phone number: ");
                String phone = sc.nextLine();
                System.out.print("Doctor numeric ID(1001‑1006): ");
                int docId = Integer.parseInt(sc.nextLine());
                System.out.print("Date (yyyy‑MM‑dd): ");
                String date = sc.nextLine();
                System.out.print("Time (HH:mm): ");
                String time = sc.nextLine();
                HealthProfessional selectedDoc = null;
                if(docId == 1001) selectedDoc = gp;
                else if(docId == 1002) selectedDoc = surgeon;
                else if(docId == 1003) selectedDoc = nurse;
                else if(docId == 1004) selectedDoc = dietitian;
                else if(docId == 1005) selectedDoc = paediatrician;
                else if(docId == 1006) selectedDoc = physio;
                if(selectedDoc == null){
                    System.out.println("Failed: Doctor ID not found");
                    continue;
                }
                Appointment newApp = new Appointment(pName, phone, selectedDoc, date, time);
                manager.addAppointment(newApp);
            } else if(opt == 2) {
                System.out.print("Patient name: ");
                String pName = sc.nextLine();
                System.out.print("Date: ");
                String date = sc.nextLine();
                System.out.print("Time: ");
                String time = sc.nextLine();
                manager.cancelAppointment(pName, date, time);
            } else if(opt == 3) {
                System.out.print("Patient name: ");
                String pName = sc.nextLine();
                System.out.print("Date: ");
                String date = sc.nextLine();
                System.out.print("Old time: ");
                String oldTime = sc.nextLine();
                System.out.print("New time: ");
                String newTime = sc.nextLine();
                manager.modifyAppointmentTime(pName, date, oldTime, newTime);
            } else if(opt == 4) {
                System.out.println("===== All Appointments =====");
                manager.printAllAppointments();
            } else if(opt == 5) {
                System.out.println("Program exit.");
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
            System.out.println();
        }
        sc.close();
    }
}
