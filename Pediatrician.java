/**
 * Subclass Pediatrician
 */
public class Pediatrician extends HealthProfessional {
    private String clinicBranch;

    public Pediatrician() {
    }

    /**
     * @param id numeric id
     * @param name name
     * @param workingDays working days
     * @param clinicBranch children clinic branch
     */
    public Pediatrician(int id, String name, String workingDays, String clinicBranch) {
        super(id, name, workingDays);
        this.clinicBranch = clinicBranch;
    }

    @Override
    public void printInfo() {
        System.out.println("Pediatrician | ID:" + getId() + " | Name:" + getName()
                + " | Working days:" + getWorkingDays() + " | Clinic Branch:" + clinicBranch);
    }

    @Override
    public String getDetails() {
        return "Pediatrician, ID:" + getId() + ", Name:" + getName()
                + ", Working days:" + getWorkingDays() + ", Clinic Branch:" + clinicBranch;
    }
}
