package user.implementation;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class CodeQLTest {

    // 1️⃣ Hardcoded credential (Security issue)
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) throws Exception {

        // 2️⃣ Null pointer dereference
        String s = null;
        System.out.println(s.length());

        // 3️⃣ SQL Injection
        String userInput = args.length > 0 ? args[0] : "admin";
        Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb", "sa", PASSWORD);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM users WHERE name = '" + userInput + "'");

        // 4️⃣ Resource leak (not closing connection properly)
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        // 5️⃣ Command Injection
        Runtime.getRuntime().exec("ls " + userInput);

        // 6️⃣ Path Traversal
        File file = new File("/tmp/" + userInput);
        file.delete();

        // 7️⃣ Insecure Deserialization
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("data.ser"));
        Object obj = ois.readObject();

        System.out.println(obj);
    }

    // 8️⃣ equals without hashCode
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CodeQLTest) {
            CodeQLTest other = (CodeQLTest) obj;
            return Objects.equals(this.PASSWORD, other.PASSWORD);
        }
        return false;
    }
}
