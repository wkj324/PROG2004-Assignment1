/**
 * Appointment class
 * Store appointment information: patient name, phone, health professional, date, time
 * Implement Comparable for sorting by date then time
 * Note: This system only supports bookings for the current day according to brief
 */
public class Appointment implements Comparable<Appointment> {
    private String patientName;
    private String patientPhone;
    private HealthProfessional provider;
    private String date;
    private String time;

    /**
     * Constructor
     * @param patientName patient name
     * @param patientPhone patient phone number
     * @param provider assigned health professional
     * @param date appointment date
     * @param time appointment time HH:mm
     */
    public Appointment(String patientName, String patientPhone, HealthProfessional provider, String date, String time) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.provider = provider;
        this.date = date;
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public HealthProfessional getProvider() {
        return provider;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Appointment other) {
        if (!this.date.equals(other.date)) {
            return this.date.compareTo(other.date);
        }
        return this.time.compareTo(other.time);
    }

    @Override
    public String toString() {
        return String.format(
                "Appointment | Patient: %-8s | Phone: %-12s | %s | Date: %s | Time: %s",
                patientName, patientPhone, provider.getDetails(), date, time
        );
    }
}
