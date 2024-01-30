/**
 * The base class for all bird species in the birdwatching game.
 */
public class Bird {
    private String name;
    private double encounterChance;
    private String specialNoise;
    private String visualDescription;

    public Bird(String name, double encounterChance, String specialNoise, String visualDescription) {
        this.name = name;
        this.encounterChance = encounterChance;
        this.specialNoise = specialNoise;
        this.visualDescription = visualDescription;
    }

    public String getName() {
        return name;
    }

    public double getEncounterChance() {
        return encounterChance;
    }

    public String getSpecialNoise() {
        return specialNoise;
    }

    public String getVisualDescription() {
        return visualDescription;
    }
}

