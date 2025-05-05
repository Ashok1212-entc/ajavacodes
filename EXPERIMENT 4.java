import java.sql.*;
public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javaprac";
        String user = "root";         // use your actual MySQL username
        String password = "Root"; // use your actual MySQL password
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");
            // INSERT data
            String insertQuery = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, 2);
            pstmt.setString(2, "bhagesh");
            pstmt.setString(3, "jambagiBhagesh@example.com");
            pstmt.executeUpdate();
            // RETRIEVE data
            String selectQuery = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            System.out.println("Users from DB:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("email"));
            }
            // Close everything
            rs.close();
            stmt.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
