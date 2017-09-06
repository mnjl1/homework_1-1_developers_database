import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProjectsDAO {
    String query;
    String projectName;
    int id;
    int customer_id;
    int cost;
    int itcompany_id;

    Projects projects = new Projects();

    int enterInteger() {
        boolean correctId = false;
        while (!correctId) {
            try {
                id = Integer.parseInt(scanner.next());
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
        query = "INSERT INTO projects (projectName, customer_id, cost, itcompany_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter project name.");
            projectName = scanner.nextLine();
            preparedStatement.setString(1, projectName);
            System.out.println("Enter customer' id.");
            customer_id = enterInteger();
            preparedStatement.setInt(2, customer_id);
            System.out.println("Enter cost.");
            cost = enterInteger();
            preparedStatement.setInt(3, cost);
            System.out.println("Enter company id.");
            itcompany_id = enterInteger();
            preparedStatement.setInt(4, itcompany_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        query = "DELETE FROM projects WHERE projectName = ? AND customer_id = ?";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter project name.");
            projectName = scanner.nextLine();
            preparedStatement.setString(1, projectName);
            System.out.println("Enter customer id");
            customer_id = enterInteger();
            preparedStatement.setInt(2, customer_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        query = "SELECT * FROM projects";
        try (Statement statement = databaseConnector.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                projects.setProjectName(resultSet.getString("projectName"));
                projects.setCustomer_id(resultSet.getInt("customer_id"));
                projects.setCost(resultSet.getInt("cost"));
                projects.setItcompany_id(resultSet.getInt("itcompany_id"));
                System.out.println(projects);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        query = "UPDATE projects SET projectName = ?, customer_id = ?, cost = ?, itcompany_id=?";

        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter project name.");
            projectName = scanner.nextLine();
            preparedStatement.setString(1, projectName);
            System.out.println("Enter customer_id.");
            customer_id = enterInteger();
            preparedStatement.setInt(2, customer_id);
            System.out.println("Enter cost.");
            cost = enterInteger();
            preparedStatement.setInt(3, cost);
            System.out.println("Enter company id.");
            itcompany_id = enterInteger();
            preparedStatement.setInt(4, itcompany_id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
