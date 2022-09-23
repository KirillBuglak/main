import buslogic.HiberUtil;
import entities.*;
import org.hibernate.Session;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class DataMain {

    public static void main(String[] args) {

            Logger logger = Logger.getLogger("Logger");

//        Guy guy = new Guy();
//
//        try(Statement statement = GuyDAO.connection.createStatement();
//            PreparedStatement preparedStatement =
//                    GuyDAO.connection.prepareStatement("insert into table2(maker,product) values (?,?)");)
//        {
//
//            preparedStatement.setInt(1,777);
//            preparedStatement.setString(1,"Marge");
//            preparedStatement.setString(2,"Apple Pie");
//            preparedStatement.execute();
//
//            ResultSet resultSet = statement.executeQuery("select * from table1");
//
//            statement.executeQuery("select * from table2");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
            Session session = HiberUtil.getSessionFactory().openSession();
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();

            try {
                session.beginTransaction();

                Provider provider1 = new Provider();
                provider1.setProviderName("Provider1");
                Provider provider2 = new Provider();
                provider2.setProviderName("Provider2");

                Parts nationalparts = new Parts();
                nationalparts.setPartName("Crankshaft");
                nationalparts.setAmountOfParts(12);

                Parts importparts = new Parts();
                importparts.setPartName("Valves");
                importparts.setAmountOfParts(100);


                Set<Provider> providerSet = new HashSet<>();
                providerSet.add(provider1);
                providerSet.add(provider2);

                Vehicle vehicle = new Vehicle();
                vehicle.setManufacturer("JMC");
                vehicle.setModel("Hummer");
                vehicle.setNationalParts(nationalparts);
                vehicle.getPartsSet().add(nationalparts);
                vehicle.getPartsSet().add(importparts);

                Vehicle vehicle2 = new Vehicle();
                vehicle2.setManufacturer("Rolls Royess");
                vehicle2.setModel("Phantom");
                vehicle2.setImportParts(importparts);

                Set<Vehicle> vehicleSet = new HashSet<>();
                vehicleSet.add(vehicle);
                vehicleSet.add(vehicle2);

                Platform platform = new Platform();
                platform.setPlatformTitle("AVITO");
                platform.setProviderSet(providerSet);
                platform.setPaltformDate(new Date());
                platform.setPaltformTime(new Date());

                Set<Platform> platformSet = new HashSet<>();
                platformSet.add(platform);

                provider1.setPlatformSet(platformSet);
                provider2.setPlatformSet(platformSet);

                Seller seller = new Seller();
                seller.setSellerName("SellerName");
                seller.setPlatform(platform);
                seller.setVehicleSet(vehicleSet);
                seller.getPartsSet().add(nationalparts);

                Client client = new Client();
                client.setClientName("James");
                client.setPlatform(platform);
                client.setSeller(seller);
                client.setVehicleSet(vehicleSet);

                vehicle.setClient(client);
                vehicle.setSeller(seller);
                vehicle.setPlatform(platform);
                vehicle2.setClient(client);
                vehicle2.setSeller(seller);
//        vehicle2.setPlatform(platform);

                session.persist(seller);
                session.persist(vehicle);
                session.persist(vehicle2);
                session.persist(platform);
                session.persist(client);
                session.persist(provider1);
                session.persist(provider2);

                Set<ConstraintViolation<Provider>> constraintViolationSet
                        = validator.validate(provider1);

                for (ConstraintViolation<Provider> c : constraintViolationSet)
                    System.err.println(c.getMessage() + ": " + c.getInvalidValue());

                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                logger.severe("Transaction has failed\n" + e);
                e.printStackTrace();
            } finally {
//                session.close();
//                HiberUtil.shutDown();
            }
            /**Getting some value from session*/
//            HiberUtil.getSessionFactory().openSession();
//            session.beginTransaction();

            Provider pr = session.get(Provider.class,1);


//            System.out.println(pr.getProviderName());
            Set<Platform> ps = pr.getPlatformSet();
            for (Platform p : ps)
                System.out.println(p.getPlatformTitle());
            session.close();
            HiberUtil.shutDown();
        }
    }