package pack.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pack.models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    private final JdbcTemplate jdbcTemplate;
//    private static int WHAT;
//    private static final String URL = "jdbc:postgresql://localhost:5432/FirstTryHere";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "password";

//    private static Connection connectionToFirstTryHere;

//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            connectionToFirstTryHere = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Car> fullList () {
//        return carList;

//            try {
//                List<Car> dataCarList = new ArrayList<>();
//                Statement statement = connectionToFirstTryHere.createStatement();
//                String SQL = "select * from car";
//                ResultSet resultSet = statement.executeQuery(SQL);
//
//                while (resultSet.next()) {
//                    Car emptyCar = new Car();
//
//                    emptyCar.setWhat(resultSet.getInt("what"));
//                    emptyCar.setManufacturer(resultSet.getString("manufacturer"));
//                    emptyCar.setYear(resultSet.getInt("year"));
//                    emptyCar.setBody(resultSet.getString("body"));
//
//                    dataCarList.add(emptyCar);
//                }
//                return dataCarList;
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
        return jdbcTemplate.query("select * from car", new BeanPropertyRowMapper<>(Car.class)
//                new CarMapper()
                );
        }

        public Car showOneCar (int what){
///**        return carList.get(what);*/
//        return carList.stream().filter(x->x.getWhat()==what).findAny().orElse(null);

//            Car car;
//
//            try {
//                PreparedStatement preparedStatement =
//                        connectionToFirstTryHere.prepareStatement("select * from car where what=?");
//                preparedStatement.setInt(1,what);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                resultSet.next();
//                car = new Car();
//                car.setWhat(resultSet.getInt(1));
//                car.setManufacturer(resultSet.getString(2));
//                car.setYear(resultSet.getInt(3));
//                car.setBody(resultSet.getString(4));
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//
//            return car;
            return jdbcTemplate.query("select * from car where what=?",
                    new Object[]{what},
//                    new CarMapper()
                    new BeanPropertyRowMapper<>(Car.class)
            ).stream().findAny().orElse(null);

        }
        public void add (Car car){
//        car.setWhat(WHAT++);
//        carList.add(car);
//            try {
//                PreparedStatement prepareStatement =
//                        connectionToFirstTryHere.prepareStatement("insert into car values (1,?,?,?)");
//                prepareStatement.setString(1, car.getManufacturer());
//                prepareStatement.setInt(2,car.getYear());
//                prepareStatement.setString(3, car.getBody());
//
//                prepareStatement.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            jdbcTemplate.update("insert into car values (1,?,?,?)",
                    car.getManufacturer(),car.getYear(),car.getBody());
        }

        public void patchEdit ( int what, Car upcar){
//        Car smcar = showOneCar(what);
//
//        smcar.setManufacturer(upcar.getManufacturer());
//        smcar.setYear(upcar.getYear());
//        smcar.setBody(upcar.getBody());

//            try {
//                PreparedStatement preparedStatement =
//                        connectionToFirstTryHere.prepareStatement(
//                                "update car set manufacturer=?,year=?,body=? where what=?");
//
//                preparedStatement.setString(1, upcar.getManufacturer());
//                preparedStatement.setInt(2,upcar.getYear());
//                preparedStatement.setString(3, upcar.getBody());
//                preparedStatement.setInt(4,what);
//
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            jdbcTemplate.update("update car set manufacturer=?,year=?,body=? where what=?",
                    upcar.getManufacturer(),upcar.getYear(),upcar.getBody(),upcar.getWhat());
        }

        public void deleteCar ( int what){
//        carList.removeIf(p->p.getWhat()==what);
//            try {
//                PreparedStatement preparedStatement =
//                        connectionToFirstTryHere.prepareStatement(
//                                "delete from car where what=?");
//                preparedStatement.setInt(1,what);
//                preparedStatement.executeUpdate();
//
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            jdbcTemplate.update("delete from car where what=?",what);
        }
}