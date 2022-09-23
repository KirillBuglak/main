package Base;

class Car extends Vehicle {
    private String body;
    Car(String manufacturer,String body){
        super(manufacturer);
        this.body=body;
    }
    public String getDescript(){
        return "Car "+ manufacturer+" has a "+body+" body type";
    }
}
