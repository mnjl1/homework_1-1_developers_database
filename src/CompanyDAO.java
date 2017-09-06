import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CompanyDAO {
    private int id;
    private int itcompany_id;
    private String companyName;
    private String query;

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

    Company company = new Company();

    DatabaseConnector databaseConnector = new DatabaseConnector();

    Scanner scanner = new Scanner(System.in);

    public void create() {

        query = "INSERT INTO itcompany VALUE ?";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter company name.");
            companyName = scanner.nextLine();
            preparedStatement.setString(1, companyName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        query = "DELETE FROM skills WHERE developer_id = ?";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter developers' id.");
            id = enterInteger();
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        query = "SELECT * FROM itcompany";
        try (Statement statement = databaseConnector.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                company.setItcompany_id(resultSet.getInt("itcompany_id"));
                company.setCompanyName(resultSet.getString("companyName"));
                System.out.println(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        query = "UPDATE itcompany SET companyName = ?";

        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter company name.");
            companyName = scanner.nextLine();
            preparedStatement.setString(1, companyName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
