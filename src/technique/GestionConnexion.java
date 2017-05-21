package technique;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionConnexion {

    private static final String url = "jdbc:mysql://localhost/pharma";
    private static final String login = "root";
    private static final String mdp = "";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection instance = null;


    private GestionConnexion() {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Problème de driver" + e.getMessage());
        }

        try {
            instance = DriverManager.getConnection(url, login, mdp);
        } catch (SQLException e) {
            System.out.println("Problème de BDD " + e.getMessage());
        }
    }

    public static Connection getConnexion() {

        if (instance == null) {
            new GestionConnexion();
        }
        return (instance);
    }

    public static void liberer() throws Exception {
        instance.close();
        instance = null;
    }
}
