package user.implementation;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class SqlInjectionTest {

    public void getUser(Connection connection, String username) throws Exception {

        Statement statement = connection.createStatement();

        // ❌ SQL Injection vulnerability
        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
    }
}
