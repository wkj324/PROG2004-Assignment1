/**
 * Subclass Dietitian
 */
public class Dietitian extends HealthProfessional {
    private String specialtyArea;

    public Dietitian() {
    }

    /**
     * @param id numeric id
     * @param name name
     * @param workingDays working days
     * @param specialtyArea nutrition specialty
     */
    public Dietitian(int id, String name, String workingDays, String specialtyArea) {
        super(id, name, workingDays);
        this.specialtyArea = specialtyArea;
    }

    @Override
    public void printInfo() {
        System.out.println("Dietitian | ID:" + getId() + " | Name:" + getName()
                + " | Working days:" + getWorkingDays() + " | Specialty:" + specialtyArea);
    }

    @Override
    public String getDetails() {
        return "Dietitian, ID:" + getId() + ", Name:" + getName()
                + ", Working days:" + getWorkingDays() + ", Specialty:" + specialtyArea;
    }
}
