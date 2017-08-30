import java.sql.SQLException;
import java.util.Scanner;

public class MenuHolder {
    Scanner scanner = new Scanner(System.in);
    DevelopersDao developersDao = new DevelopersDao();

    public MenuHolder() throws SQLException {
    }

    void menu() {
        System.out.println("Make your choice;");
        System.out.println("1.Print developers list.");
        System.out.println("2.Add developer.");
        System.out.println("3. Delete developer by last name");
        System.out.println("4. Creat new skill");
        System.out.println("5. Add new developer' skill");


        int choice = scanner.nextInt();
        switch (choice) {
            case (1): {
                developersDao.getDevelopersList();
                break;
            }
            case (2): {
                developersDao.createDeveloper();
                break;
            }
            case (3): {
                developersDao.deleteDeveloper();
                break;
            }
            case (4) : {
                SkillDAO skillDAO = new SkillDAO();
                skillDAO.createSkill();

                break;
            }
            default:
                System.out.println("Wrong choice.");
        }
    }
}
