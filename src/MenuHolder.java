import java.util.Scanner;

public class MenuHolder {

    Scanner scanner = new Scanner(System.in);
    DevelopersDao developersDao = new DevelopersDao();

    public MenuHolder()  {
    }

//    void menu() {
//
//            System.out.println("Make your choice;");
//            System.out.println("1.Print developers list.");
//            System.out.println("2.Add developer.");
//            System.out.println("3. Delete developer by last name");
//            System.out.println("4. Create new skills");
//            System.out.println("5. Add skills to developer");
//            System.out.println("10. Exit.");
//
//
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case (1): {
//                    developersDao.getDevelopersList();
//                    break;
//                }
//                case (2): {
//                    developersDao.createDeveloper();
//                    break;
//                }
//                case (3): {
//                    developersDao.deleteDeveloper();
//                    break;
//                }
//                case (4): {
//                    SkillsDAO skillDAO = new SkillsDAO();
//                    skillDAO.createSkill();
//                    break;
//                }
//                case (5) : {
//                    developersDao.addSkillToDeveloper();
//                    break;
//                }
//                case (10): {
//                    System.exit(0);
//                }
//                default:
//                    System.out.println("Wrong choice.");
//            }
//        }
    }

