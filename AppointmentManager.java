/**
 * AppointmentManager manages all appointment records.
 * Check new time format and range before updating appointment
 */

import java.util.ArrayList;
import java.util.Collections;

public class AppointmentManager {
    private ArrayList<Appointment> appointmentList;

    public AppointmentManager() {
        appointmentList = new ArrayList<>();
    }

    /**
     * Check if time is between 08:00 and 16:00
     * @param time time string HH:mm
     * @return true if within time range
     */
    public boolean isValidTimeRange(String time) {
        return time.compareTo("08:00") >= 0 && time.compareTo("16:00") <= 0;
    }

    /**
     * Check time slot follows 30‑minute interval rule (00 or 30 minutes)
     * @param time time string HH:mm
     * @return true if minutes part is 00 or 30
     */
    public boolean isValidTimeSlot(String time) {
        if(time.length() != 5) return false;
        String minutePart = time.substring(3);
        return minutePart.equals("00") || minutePart.equals("30");
    }

    /**
     * Combined time validation: range + 30‑minute slot
     * @param time time string HH:mm
     * @return true if fully valid
     */
    public boolean isTimeValid(String time) {
        return isValidTimeRange(time) && isValidTimeSlot(time);
    }

    /**
     * Add new appointment with validation
     * @param appointment new appointment
     * @return true if added successfully
     */
    public boolean addAppointment(Appointment appointment) {
        if (!isTimeValid(appointment.getTime())) {
            System.out.println("Failed: Invalid time. Allowed 08:00‑16:00, only 30‑min slots (xx:00 / xx:30).");
            return false;
        }
        for (Appointment app : appointmentList) {
            if (app.getProvider().getId() == appointment.getProvider().getId()
                    && app.getDate().equals(appointment.getDate())
                    && app.getTime().equals(appointment.getTime())) {
                System.out.println("Failed: Duplicate appointment for this provider at same time");
                return false;
            }
        }
        appointmentList.add(appointment);
        System.out.println("Success: Appointment added");
        return true;
    }

    /**
     * Sort appointments by date then time
     */
    public void sortAppointments() {
        Collections.sort(appointmentList);
    }

    /**
     * Filter appointments by doctor numeric ID
     * @param doctorId target doctor id
     * @return filtered list
     */
    public ArrayList<Appointment> filterByDoctorId(int doctorId) {
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment app : appointmentList) {
            if (app.getProvider().getId() == doctorId) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * Filter appointments by patient phone number (required by brief)
     * @param phone patient phone number
     * @return filtered appointment list
     */
    public ArrayList<Appointment> filterByPatientPhone(String phone) {
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment app : appointmentList) {
            if (app.getPatientPhone().equals(phone)) {
                result.add(app);
            }
        }
        return result;
    }

     /**
     * Cancel appointment by patient name, date, time
     * Test: verify system feedback when cancelling non-existing appointment
     * @param patientName patient name
     * @param date appointment date
     * @param time appointment time
     * @return true if cancelled
     */
    public boolean cancelAppointment(String patientName, String date, String time) {
        for (Appointment app : appointmentList) {
            if (app.getPatientName().equals(patientName)
                    && app.getDate().equals(date)
                    && app.getTime().equals(time)) {
                appointmentList.remove(app);
                System.out.println("Success: Appointment cancelled");
                return true;
            }
        }
        System.out.println("Failed: Cannot find this appointment");
        return false;
    }

    /**
     * Overloaded cancel: cancel by doctor id, date, time (required by brief)
     * @param doctorId numeric doctor id
     * @param date appointment date
     * @param time appointment time
     * @return true if cancelled
     */
    public boolean cancelAppointment(int doctorId, String date, String time) {
        for (Appointment app : appointmentList) {
            if (app.getProvider().getId() == doctorId
                    && app.getDate().equals(date)
                    && app.getTime().equals(time)) {
                appointmentList.remove(app);
                System.out.println("Success: Appointment cancelled by doctor ID and time");
                return true;
            }
        }
        System.out.println("Failed: Cannot find target appointment");
        return false;
    }

       /**
     * Modify appointment time with full time validation
     * Check new time format and range before updating appointment
     * @param patientName patient name
     * @param date original date
     * @param oldTime original time
     * @param newTime new time
     * @return true if modified
     */
    public boolean modifyAppointmentTime(String patientName, String date, String oldTime, String newTime) {
        if (!isTimeValid(newTime)) {
            System.out.println("Failed: Invalid time. Allowed 08:00‑16:00, only 30‑min slots (xx:00 / xx:30).");
            return false;
        }
        Appointment target = null;
        for (Appointment app : appointmentList) {
            if (app.getPatientName().equals(patientName)
                    && app.getDate().equals(date)
                    && app.getTime().equals(oldTime)) {
                target = app;
                break;
            }
        }
        if (target == null) {
            System.out.println("Failed: Cannot find this appointment");
            return false;
        }
        for (Appointment app : appointmentList) {
            if (app != target
                    && app.getProvider().getId() == target.getProvider().getId()
                    && app.getDate().equals(target.getDate())
                    && app.getTime().equals(newTime)) {
                System.out.println("Failed: Duplicate appointment for this provider at same time");
                return false;
            }
        }
        target.setTime(newTime);
        System.out.println("Success: Appointment time modified");
        return true;
    }

    /**
     * Print all appointments
     */
    public void printAllAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }
        for (Appointment app : appointmentList) {
            System.out.println(app);
        }
    }

    public ArrayList<Appointment> getAllAppointments() {
        return appointmentList;
    }
}
