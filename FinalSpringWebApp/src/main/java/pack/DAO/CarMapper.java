package pack.DAO;


import org.springframework.jdbc.core.RowMapper;
import pack.models.Car;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();

        car.setWhat(resultSet.getInt(1));
        car.setManufacturer(resultSet.getString(2));
        car.setYear(resultSet.getInt(3));
        car.setBody(resultSet.getString(4));

        return car;
    }
}
