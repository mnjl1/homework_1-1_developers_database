import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SkillDAO {
    String query;
    String skillName;
    Skill skill = new Skill();
    Scanner scanner = new Scanner(System.in);

    DatabaseConnector databaseConnector = new DatabaseConnector();

    public void createSkill(){

        query = "INSERT INTO skills(skillName) VALUE(?)" ;
        try(PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query)) {
            System.out.println("Enter new skill name.");
            skillName = scanner.nextLine();
            preparedStatement.setString(1, skillName);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
