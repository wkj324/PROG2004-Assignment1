/**
 * Subclass Physiotherapist
 */
public class Physiotherapist extends HealthProfessional {
    private String therapyType;

    public Physiotherapist() {
    }

    /**
     * @param id numeric id
     * @param name name
     * @param workingDays working days
     * @param therapyType rehabilitation therapy type
     */
    public Physiotherapist(int id, String name, String workingDays, String therapyType) {
        super(id, name, workingDays);
        this.therapyType = therapyType;
    }

    @Override
    public void printInfo() {
        System.out.println("Physiotherapist | ID:" + getId() + " | Name:" + getName()
                + " | Working days:" + getWorkingDays() + " | Therapy Type:" + therapyType);
    }

    @Override
    public String getDetails() {
        return "Physiotherapist, ID:" + getId() + ", Name:" + getName()
                + ", Working days:" + getWorkingDays() + ", Therapy Type:" + therapyType;
    }
}
