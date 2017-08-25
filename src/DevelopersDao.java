import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DevelopersDao {
    String queary;
    Developers developers = new Developers();
    DatabaseConnector databaseConnector = new DatabaseConnector();

    Scanner scanner = new Scanner(System.in);
    public DevelopersDao() throws SQLException {
    }

    public void createDeveloper(){
        int salary;
        queary = "INSERT INTO developers (firstName, lastName, salary) VALUES (?, ?, ?)";
        try(PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(queary)) {
            System.out.println("Enter first name:");
            String firstName = scanner.nextLine();
            preparedStatement.setString(1,firstName);
            System.out.println("Enter last name");
            String lastName = scanner.nextLine();
            preparedStatement.setString(2, lastName);
            System.out.println("Enter salary:");
            salary = scanner.nextInt();
            preparedStatement.setInt(3, salary);
            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDevelopersList(){

        try {
            Statement statement = databaseConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");
            while (resultSet.next()){
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
