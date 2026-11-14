/**
 * Subclass General Practitioner
 */
public class GeneralPractitioner extends HealthProfessional {
    private String clinicName;

    public GeneralPractitioner() {
    }

    /**
     * @param id numeric id
     * @param name name
     * @param workingDays working days
     * @param clinicName clinic name
     */
    public GeneralPractitioner(int id, String name, String workingDays, String clinicName) {
        super(id, name, workingDays);
        this.clinicName = clinicName;
    }

    @Override
    public void printInfo() {
        System.out.println("General Practitioner | ID:" + getId() + " | Name:" + getName()
                + " | Working days:" + getWorkingDays() + " | Clinic:" + clinicName);
    }

    @Override
    public String getDetails() {
        return "General Practitioner, ID:" + getId() + ", Name:" + getName()
                + ", Working days:" + getWorkingDays() + ", Clinic:" + clinicName;
    }
}
