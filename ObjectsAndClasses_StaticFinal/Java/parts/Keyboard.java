package parts;

public class Keyboard {
    private final String type;
    private final boolean hasLights;
    private final double weight;

    public Keyboard(String type, boolean hasLights, double weight) {
        this.type = type;
        this.hasLights = hasLights;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public boolean isHasLights() {
        return hasLights;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "type=" + type + '\'' +
                ", hasLights=" + hasLights +
                ", weight=" + weight +
                '}';
    }
}
