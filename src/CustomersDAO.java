import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomersDAO {
    String query;
    int id;
    int customer_id;
    String customerName;

    Customers customers = new Customers();

    DatabaseConnector databaseConnector = new DatabaseConnector();

    Scanner scanner = new Scanner(System.in);

    public void create() {

        query = "INSERT INTO customers VALUE ?";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter customer name.");
            customerName = scanner.nextLine();
            preparedStatement.setString(1, customerName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        query = "DELETE FROM customers WHERE customerName = ?";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter customer' name.");
            customerName = scanner.nextLine();
            preparedStatement.setString(1, customerName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        query = "SELECT * FROM customers";
        try(Statement statement = databaseConnector.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                customers.setCustomer_id(resultSet.getInt(customer_id));
                customers.setCustomerName(resultSet.getString(customerName));
                System.out.println(customers);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        query ="UPDATE customers SET customerName = ?";

        try(PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter customer name.");
            customerName = scanner.nextLine();
            preparedStatement.setString(1, customerName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
