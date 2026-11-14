/**
 * Superclass HealthProfessional
 * Abstract class, cannot be instantiated directly
 * Store common data for all health professionals: numeric id, name, working days
 */
public abstract class HealthProfessional {
    private int id;
    private String name;
    private String workingDays;

    /**
     * No‑arg constructor
     */
    public HealthProfessional() {
    }

    /**
     * Parameterised constructor
     * @param id numeric only identifier
     * @param name name of health professional
     * @param workingDays weekly working days
     */
    public HealthProfessional(int id, String name, String workingDays) {
        this.id = id;
        this.name = name;
        this.workingDays = workingDays;
    }

    /**
     * Get numeric id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get working days
     * @return workingDays
     */
    public String getWorkingDays() {
        return workingDays;
    }

    /**
     * Print information to console
     */
    public abstract void printInfo();

    /**
     * Return full details as string for Appointment toString output
     * @return full description string
     */
    public abstract String getDetails();
}
