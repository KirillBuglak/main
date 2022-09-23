package Base;

class Motorcycle extends Vehicle {
    private double capac;
    Motorcycle(String manufacturer, double capac) {
        super(manufacturer);
        this.capac = capac;
    }
    public String getDescript() {
        return "Motorcycle " + manufacturer + " has a " + capac + " L tank";
    }
}
