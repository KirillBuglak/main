package GenericClassesVariousMeths;


import GenericClassesVariousMeths.Wheels.BBC;
import GenericClassesVariousMeths.Wheels.Stocks;
import GenericClassesVariousMeths.Wheels.Wheels;

public class Main {
    public static void main(String[] args) {

        Doors doors = new Doors();

             BBC bbc = new BBC(5,"Silver Steel");
        Stocks stocs = new Stocks(4,"Golden Steel");


        FullBike <BBC> moto1 = new FullBike<>(bbc,"Diamond","Carbon",125.75);
        moto1.getWheels().burn();

        FullBike <Stocks> moto2 = new FullBike<>(stocs,"Brilliant","Fiberglass", 130.45);
        moto2.getWheels().dirt();

       /* try{
        FullBike <Doors> moto3 = new FullBike<>(doors,"Brilliant","Fiberglass", 130.45);
        moto3.getWheels().squek();}
        catch (Exception e){
            throw e;
        }*/





    }
}
