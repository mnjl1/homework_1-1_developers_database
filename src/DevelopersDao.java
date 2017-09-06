import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DevelopersDao {
    private static int id;
    String query;
    String firstName;
    String lastName;
    Developers developers = new Developers();

    //method for entering Integer to any query
    int enterInteger() {
        boolean correctId = false;
        while (!correctId) {
            try {
                int id = Integer.parseInt(scanner.next());
                correctId = true;
            } catch (Exception e) {
                System.out.println("Wrong id!");
            }
        }
        return id;
    }

    DatabaseConnector databaseConnector = new DatabaseConnector();

    Scanner scanner = new Scanner(System.in);

    public void create() {
        int salary;
        query = "INSERT INTO developers (firstName, lastName, salary) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter first name:");
            firstName = scanner.nextLine();
            preparedStatement.setString(1, firstName);
            System.out.println("Enter last name");
            lastName = scanner.nextLine();
            preparedStatement.setString(2, lastName);
            System.out.println("Enter salary:");
            salary = scanner.nextInt();
            preparedStatement.setInt(3, salary);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        query = "DELETE FROM developers WHERE developer_id = ?";
        System.out.println("Enter developers' id.");
        id = enterInteger();
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        query = "SELECT * FROM developers";
        try (Statement statement = databaseConnector.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                developers.setId(resultSet.getInt(1));
                developers.setFirstName(resultSet.getString("firstName"));
                developers.setLastName(resultSet.getString("lastName"));
                developers.setSalary(resultSet.getInt("salary"));
                System.out.println(developers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        query = "UPDATE developers SET firstName = ?, lastName = ?, itcompany_id = ?, salary = ?";

        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter first name.");
            firstName = scanner.nextLine();
            preparedStatement.setString(1, firstName);
            System.out.println("Enter last name.");
            lastName = scanner.nextLine();
            preparedStatement.setString(2, lastName);
            System.out.println("Enter company id");
            id = enterInteger();
            preparedStatement.setInt(3, id);
            System.out.println("Enter salary.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
