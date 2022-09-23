public class Order {
    private final Dimensions dimensions;
    private final double mass;
    private final String deliveryAddress;
    private final boolean canBeTurned;
    private final String registerNumber;
    private final boolean isFragile;

    public Order(Dimensions dimensions, double mass, String deliveryAddress,
                 boolean canBeTurned, String registerNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.deliveryAddress = deliveryAddress;
        this.canBeTurned = canBeTurned;
        this.registerNumber = registerNumber;
        this.isFragile = isFragile;
    }

    public Order setDeliveryAddress(String deliveryAddress) {
        return new Order(dimensions, mass, deliveryAddress,
                canBeTurned, registerNumber, isFragile);
    }

    public Order setDimensions(Dimensions dimensions) {
        return new Order(dimensions, mass, deliveryAddress,
                canBeTurned, registerNumber, isFragile);
    }

    public Order setMass(double mass) {
        return new Order(dimensions, mass, deliveryAddress,
                canBeTurned, registerNumber, isFragile);
    }
}