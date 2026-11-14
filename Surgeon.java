/**
 * Subclass Surgeon
 */
public class Surgeon extends HealthProfessional {
    private String specialty;

    public Surgeon() {
    }

    /**
     * @param id numeric id
     * @param name name
     * @param workingDays working days
     * @param specialty surgery specialty
     */
    public Surgeon(int id, String name, String workingDays, String specialty) {
        super(id, name, workingDays);
        this.specialty = specialty;
    }

    @Override
    public void printInfo() {
        System.out.println("Surgeon | ID:" + getId() + " | Name:" + getName()
                + " | Working days:" + getWorkingDays() + " | Specialty:" + specialty);
    }

    @Override
    public String getDetails() {
        return "Surgeon, ID:" + getId() + ", Name:" + getName()
                + ", Working days:" + getWorkingDays() + ", Specialty:" + specialty;
    }
}
