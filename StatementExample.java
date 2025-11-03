import java.sql.*;

public class StatementExample {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exampledb", "root", "");
            Statement stmt = con.createStatement();
            
            // Insert all columns
            String sql = "INSERT INTO student (id, name, age, course) VALUES (1, 'Amisha', 21, 'BSc CSIT')";
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows + " row(s) inserted using Statement.");
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
