/**
 * Represents a thing that is not a bird.
 * This non bird has a unique visual description.
 */
public class NonBird {
    private String name;
    private String visualDescription;
    private String specialNoise;

    public NonBird(String name, String visualDescription, String specialNoise) {
        this.name = name;
        this.visualDescription = visualDescription;
        this.specialNoise = specialNoise;
    }

    public String getName() {
        return name;
    }

    public String getVisualDescription() {
        return visualDescription;
    }

    public String getSpecialNoise() {
        return specialNoise;
    }
}
