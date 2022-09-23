package pack.DAO;

import org.springframework.stereotype.Component;
import pack.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private static int ID;

    private static final String URL = "jdbc:postgresql://localhost:5432/JustACopy";
    private static final String PASSWORD = "password";
    private static final String USERNAME = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String querry = "select * from product_table";
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()) {
                Product product = new Product();
                int id = resultSet.getInt("id");
                String label = resultSet.getString("label");
                String mail = resultSet.getString("mail");
                product.setId(id);
                product.setLabel(label);
                product.setMail(mail);
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static Product getOne(final int id) {
//        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product_table where id =?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
                product.setLabel(resultSet.getString("label"));
                product.setMail(resultSet.getString("mail"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public static void save(Product product) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("insert into product_table(label,mail) values(?,?)");
            String label = product.getLabel();
            String mail = product.getMail();
//            statement1.setInt(1, ID++);
            statement1.setString(1, label);
            statement1.setString(2, mail);
            statement1.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(int id, Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("update product_table set label=?,mail=? where id=?");
            statement.setString(1, product.getLabel());
            statement.setString(2, product.getMail());
            statement.setInt(3, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from product_table where id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}