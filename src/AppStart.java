import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppStart {
    public static void main(String[] args) {
        MenuHolder menuHolder = null;
        try {
            menuHolder = new MenuHolder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        menuHolder.menu();
    }
}
