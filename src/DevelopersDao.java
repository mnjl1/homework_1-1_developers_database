import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DevelopersDao {
    String queary;
    String firstName;
    String lastName;
    Developers developers = new Developers();
    DatabaseConnector databaseConnector = new DatabaseConnector();

    Scanner scanner = new Scanner(System.in);

    public void createDeveloper() {
        int salary;
        queary = "INSERT INTO developers (firstName, lastName, salary) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(queary)) {
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

    public void addSkillToDeveloper() {
        queary = "UPDATE skills SET developer_id = ? WHERE skillName = ?";
        try (Statement statement = databaseConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_UPDATABLE)) {
            System.out.println("Enter developer's last name.");
            lastName = scanner.nextLine();

            int id;
            try (ResultSet resultSet = statement.executeQuery("SELECT developer_id FROM developers " +
                    "WHERE lastName = '" + lastName + "'")) {
                resultSet.last();
                id = resultSet.getInt("developer_id");

            }

            try(PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(queary)){
                     preparedStatement.setInt(1, id );
                     System.out.println("Enter skill name");
                     String skillName = scanner.nextLine();
                     preparedStatement.setString(2, skillName);
                     preparedStatement.executeUpdate();
                 }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeveloper() {
        System.out.println("Enter developer's last name to delete from database.");
        lastName = scanner.nextLine();
        queary = "delete from developers where lastName = '" + lastName + "'";

        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(queary)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDevelopersList() {

        try (Statement statement = databaseConnector.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");
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
}
