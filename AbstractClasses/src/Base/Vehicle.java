package Base;

public abstract class Vehicle {
    public String manufacturer;
    public abstract String getDescript();
    public Vehicle(String manufacturer) {
        this.manufacturer=manufacturer;
    }
    public void getManufacturer(){
        System.out.println("\nThe manufacturer is "+manufacturer);
    }
}
