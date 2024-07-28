import java.sql.*;

public class MyQuery {

    private Connection conn = null;
    private Statement statement = null;

    public MyQuery(Connection c) throws SQLException {
        conn = c;
        // Statements allow to issue SQL queries to the database
        statement = conn.createStatement();
    }

    public void insertTestDoctor(String username, String password, String first_name, String last_name, String specialty, String contact_info, String email) throws SQLException {
        // Insert into UserAccount
        String insertUserAccount = "INSERT INTO UserAccount (username, password, role) VALUES (?, ?, 'Doctor')";
        try (PreparedStatement pstmt = conn.prepareStatement(insertUserAccount, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password); // Directly store plain text password
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int user_id = generatedKeys.getInt(1);

                // Insert into Doctors using the generated user_id
                String insertDoctor = "INSERT INTO Doctors (user_id, first_name, last_name, specialty, contact_info, email) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmtDoctor = conn.prepareStatement(insertDoctor)) {
                    pstmtDoctor.setInt(1, user_id);
                    pstmtDoctor.setString(2, first_name);
                    pstmtDoctor.setString(3, last_name);
                    pstmtDoctor.setString(4, specialty);
                    pstmtDoctor.setString(5, contact_info);
                    pstmtDoctor.setString(6, email);
                    pstmtDoctor.executeUpdate();
                }
            } else {
                throw new SQLException("Creating user account failed, no ID obtained.");
            }
        }
    }
}
