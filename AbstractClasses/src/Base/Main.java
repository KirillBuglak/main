package Base;

public class Main {

    public static void main(String[] args) {
Vehicle [] vech = new Vehicle[2];
vech[0]=new Car("Toyota","hatchback");
vech[1]=new Motorcycle("BMW",20.23);
for (Vehicle e: vech){
    System.out.println(e.getDescript());
}
vech[0].getManufacturer();

    }
}
