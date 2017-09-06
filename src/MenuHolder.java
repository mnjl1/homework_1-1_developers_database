import java.util.Scanner;

public class MenuHolder {
    Scanner scanner = new Scanner(System.in);

    public MenuHolder() {

    }

    public void menu() {
        while (true) {
            System.out.println("Make your choice.");
            System.out.println("1. Developers");
            System.out.println("2. Skills");
            System.out.println("3. Companies");
            System.out.println("4. Customers");
            System.out.println("5. Projects");
            System.out.println("6. Exit app");

            int choiceDev = scanner.nextInt();
            switch (choiceDev) {
                case (1): {
                    DevelopersDao developersDao = new DevelopersDao();
                    System.out.println("1.Create developer");
                    System.out.println("2.Update developer");
                    System.out.println("3.Get all developers");
                    System.out.println("4.Delete developer");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case (1): {
                            developersDao.create();
                            break;
                        }
                        case (2): {
                            developersDao.update();
                            break;
                        }
                        case (3): {
                            developersDao.get();
                            break;
                        }
                        case (4): {
                            developersDao.delete();
                            break;
                        }
                        default:
                            System.out.println("Wrong choice.");
                    }
                    break;
                }
                case (2): {
                    SkillsDAO skillsDAO = new SkillsDAO();
                    System.out.println("1.Create Skill");
                    System.out.println("2.Update Skill");
                    System.out.println("3.Get all skills");
                    System.out.println("4.Delete skill");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case (1): {
                            ;
                            break;
                        }
                        case (2): {
                            skillsDAO.update();
                            break;
                        }
                        case (3): {
                            skillsDAO.get();
                            break;
                        }
                        case (4): {
                            skillsDAO.delete();
                            break;
                        }
                        default:
                            System.out.println("Wrong choice.");
                    }
                    break;
                }
                case (3): {
                    CompanyDAO companyDAO = new CompanyDAO();
                    System.out.println("1.Create company");
                    System.out.println("2.Update company");
                    System.out.println("3.Get all company");
                    System.out.println("4.Delete company");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case (1): {
                            companyDAO.create();
                            break;
                        }
                        case (2): {
                            companyDAO.update();
                            break;
                        }
                        case (3): {
                            companyDAO.get();
                            break;
                        }
                        case (4): {
                            companyDAO.delete();
                            break;
                        }
                        default:
                            System.out.println("Wrong choice.");
                    }
                    break;
                }
                case (4): {
                    CustomersDAO customersDAO = new CustomersDAO();
                    System.out.println("1.Create customer");
                    System.out.println("2.Update customer");
                    System.out.println("3.Get all customers");
                    System.out.println("4.Delete customer");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case (1): {
                            customersDAO.create();
                            break;
                        }
                        case (2): {
                            customersDAO.update();
                            break;
                        }
                        case (3): {
                            customersDAO.get();
                            break;
                        }
                        case (4): {
                            customersDAO.delete();
                            break;
                        }
                        default:
                            System.out.println("Wrong choice.");
                    }
                    break;
                }
                case (5): {
                    ProjectsDAO projectsDAO = new ProjectsDAO();
                    System.out.println("1.Create project");
                    System.out.println("2.Update project");
                    System.out.println("3.Get all projects");
                    System.out.println("4.Delete project");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case (1): {
                            projectsDAO.create();
                            break;
                        }
                        case (2): {
                            projectsDAO.update();
                            break;
                        }
                        case (3): {
                            projectsDAO.get();
                            break;
                        }
                        case (4): {
                            projectsDAO.delete();
                            break;
                        }
                        default:
                            System.out.println("Wrong choice.");
                    }
                    break;
                }
                case (6): {
                    System.exit(0);
                }
            }
        }
    }
}

