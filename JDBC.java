import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            MyQuery mquery = new MyQuery(conn);
            System.out.println("Yo it worked");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        //Create a connection to the database
        String serverName = "rds-mysql-cscd350.cv4g0yucc9qe.us-west-2.rds.amazonaws.com:3306";
        String mydatabase = "HealthConnect"; //change needed
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url
        String username = "admin"; //change needed
        String password = "administrator"; //change needed

        connection = DriverManager.getConnection(url, username, password);
        return connection;

    }
}