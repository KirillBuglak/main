package parts;

import enums.HDType;

public class HardDrive {
    private final HDType type;
    private final int memoryCapacity;
    private final double weight;

    public HardDrive(HDType type, int memoryCapacity, double weight) {
        this.type = type;
        this.memoryCapacity = memoryCapacity;
        this.weight = weight;
    }

    public HDType getType() {
        return type;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "HardDrive{" +
                "type=" + type +
                ", memoryCapacity=" + memoryCapacity +
                ", weight=" + weight +
                '}';
    }
}
