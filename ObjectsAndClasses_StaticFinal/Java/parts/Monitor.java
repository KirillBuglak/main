package parts;

import enums.MonitorType;

public class Monitor {
    private final double diagonal;
    private final MonitorType type;
    private final double weight;

    public Monitor(double diagonal, MonitorType monitorType, double weight) {
        this.diagonal = diagonal;
        this.type = monitorType;
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public MonitorType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "diagonal=" + diagonal +
                ", type=" + type +
                ", weight=" + weight +
                '}';
    }
}
