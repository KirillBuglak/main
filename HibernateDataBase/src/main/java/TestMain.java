import buslogic.HiberUtil;
import entities.Vehicle;
import entities.Client;
import entities.Parts;
import entities.Seller;
import entities.inheretance.Motorcycle;
import entities.inheretance.Truck;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {
        /**
         * Auto Many to One = Books
         * Seller One to Many = Subject
         * Undo hibernate.cfg CREATE*/
        Session session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Parts parts = new Parts();

        parts.setPartName("PART_NAME");
        parts.setAmountOfParts(23);

        Vehicle vehicle = new Vehicle();
        vehicle.setModel("Model");
        vehicle.setManufacturer("JSM");

        Truck truck = new Truck();
        truck.setModel("FREIGHTER");
        truck.setManufacturer("FORD");
        truck.setCabinType("TRUCK CABIN");

        Motorcycle moto = new Motorcycle();
        moto.setModel("CBR100rr");
        moto.setManufacturer("HONDA");
        moto.setHorsePower(213);

        Client client = new Client();/**Because this field can't be null in Auto.class*/

        Set<Vehicle> vehicleSet = new HashSet<>();
//        vehicleSet.add(vehicle);
        vehicleSet.add(truck);
        vehicleSet.add(moto);

        Seller seller = new Seller();
        seller.setSellerName("Greg");
        seller.setVehicleSet(vehicleSet);
        seller.getPartsSet().add(parts);

        vehicle.setSeller(seller);
        vehicle.setClient(client);/**Look up there*/

        truck.setSeller(seller);
        truck.setClient(client);

        moto.setSeller(seller);
        moto.setClient(client);

/**Because @CASCADE can be used in any referenced class we can @Persist only one instance, which has this Cascade annotation*/

/**        session.persist(seller); May not save cause of CASCADE.ALL for Seller in Auto*/
        session.persist(vehicle);/**Comment this and make Set<Auto> field in Seller EAGER</Auto>*/
        session.persist(seller);
        session.persist(moto);
        session.persist(truck);
        session.getTransaction().commit();
        session.close();

        session = HiberUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Seller sellerFromSession = session.get(Seller.class,1);
        Vehicle vehicleFromSession = session.get(Vehicle.class,1);/**Comment this and make Set<Auto> field in Seller EAGER</Auto>*/

        /** NOT PERMANENT*/

        Motorcycle motoFromSession = session.get(Motorcycle.class,2);
        Truck truckFromSession = session.get(Truck.class,3);

        session.getTransaction().commit();
        session.close();
        HiberUtil.shutDown();

        System.out.println(sellerFromSession.getSellerName());
        /**  System.out.println(sellerFromSession.getAutoSet());Cannot get this with LAZY fetch*/
        System.out.println(vehicleFromSession.getManufacturer());/**Comment this and make Set<Auto> field in Seller EAGER</Auto>*/
        System.out.println(sellerFromSession.getPartsSet());/**Cannot get this with LAZY fetch*/

        /** NOT PERMANENT*/
        System.out.println(motoFromSession.getHorsePower());
        System.out.println(truckFromSession.getCabinType());

    }
}