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
        databaseConnector = null;
        System.out.println("Enter new skill name.");
        skillName = scanner.nextLine();
        query = "INSERT INTO skills VALUE("+skillName+")" ;
        try(PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(query);) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
