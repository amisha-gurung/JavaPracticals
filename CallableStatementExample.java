// DELIMITER //
// CREATE PROCEDURE AddStudent(IN sid INT, IN sname VARCHAR(50))
// BEGIN
//     INSERT INTO student(id, name) VALUES (sid, sname);
// END //
// DELIMITER ;

import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exampledb", "root", "");
            CallableStatement cstmt = con.prepareCall("{call AddStudent(?, ?)}");
            cstmt.setInt(1, 3);
            cstmt.setString(2, "Amit");
            cstmt.execute();
            System.out.println("Student added using CallableStatement.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
