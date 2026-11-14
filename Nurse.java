/**
 * Subclass Nurse
 */
public class Nurse extends HealthProfessional {
    private String ward;

    public Nurse() {
    }

    /**
     * @param id numeric id
     * @param name name
     * @param workingDays working days
     * @param ward ward name
     */
    public Nurse(int id, String name, String workingDays, String ward) {
        super(id, name, workingDays);
        this.ward = ward;
    }

    @Override
    public void printInfo() {
        System.out.println("Nurse | ID:" + getId() + " | Name:" + getName()
                + " | Working days:" + getWorkingDays() + " | Ward:" + ward);
    }

    @Override
    public String getDetails() {
        return "Nurse, ID:" + getId() + ", Name:" + getName()
                + ", Working days:" + getWorkingDays() + ", Ward:" + ward;
    }
}
