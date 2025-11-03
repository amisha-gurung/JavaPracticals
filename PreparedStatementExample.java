import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exampledb", "root", "");
            
            // Specify column names - insert into name and age columns only
            String sql = "INSERT INTO student (name, age, course) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, "Rita Sharma");
            pstmt.setInt(2, 22);
            pstmt.setString(3, "BCA");
            
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted using PreparedStatement.");
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

