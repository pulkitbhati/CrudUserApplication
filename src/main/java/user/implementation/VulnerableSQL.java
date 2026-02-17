package user.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableSQL {

    public void findUser(String username) throws Exception {

        Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb", "sa", "");

        Statement stmt = conn.createStatement();

        // ❌ SQL Injection vulnerability
        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }

        conn.close();
    }
}
