package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            setDBCredentials();
            Class.forName("com.mysql.cj.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

    public static void setDBCredentials() {

        String deployed = System.getenv("DEPLOYED");

        if (deployed != null) {

            //production(prod): hent variabelværdier fra setenv.sh
            URL = System.getenv("CONNECTION_STR");    //System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("USER");                             //System.getenv("JDBC_USER");
            PASSWORD = System.getenv("PW");                 //System.getenv("JDBC_PASSWORD");
            /*
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
            */
        } else {
            URL = "jdbc:mysql://localhost:3306/forum?allowPublicKeyRetrieval=true&serverTimezone=CET&useSSL=false";
            USERNAME = "dev";
            PASSWORD = "ax2";
        }

    }
}
