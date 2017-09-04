import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SkillsDAO {
    int id;
    String query;
    String skillName;
    Skills skills = new Skills();

    //method for entering Integer to any query
      int enterInteger(){
        boolean correctId = false;
        while (!correctId){
            try {
                id = Integer.parseInt(scanner.next());
                correctId = true;
            }catch (Exception e){
                System.out.println("Wrong id!");
            }
        }
        return id;
    }

    DatabaseConnector databaseConnector = new DatabaseConnector();

    Scanner scanner = new Scanner(System.in);

    public void create() {

        query = "INSERT INTO skills (developer_id,skillName) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter developer' id.");
            id = enterInteger();
            preparedStatement.setInt(1, id);
            System.out.println("Enter skills name.");
            skillName = scanner.nextLine();
            preparedStatement.setString(2, skillName);
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
        query = "SELECT * FROM skills";
        try(Statement statement = databaseConnector.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                skills.setDeveloper_id(resultSet.getInt("skillName"));
                skills.setDeveloper_id(resultSet.getInt("developer_id"));
                System.out.println(skills);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        query ="UPDATE skills SET skillName = ?, developer_id = ?";

        try(PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter Skill name.");
            skillName = scanner.nextLine();
            preparedStatement.setString(1, skillName);
            System.out.println("Enter developer' id");
            id = enterInteger();
            preparedStatement.setInt(2, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
