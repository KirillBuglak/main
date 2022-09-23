import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GuyDAO {
    static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/dataBase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

     static {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}