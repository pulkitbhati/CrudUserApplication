package user.implementation;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.MessageDigest;

public class TestStaticAnalysisTest {

    // Hardcoded credentials (CodeQL / Secret scan)
    private static final String PASSWORD = "admin123";
    private static final String API_KEY = "sk_test_123456789";

    // Mutable static field (PMD)
    public static List<String> globalList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // Null pointer risk (SpotBugs)
        String input = null;
        System.out.println(input.length());

        // SQL Injection (CodeQL)
        String userInput = args.length > 0 ? args[0] : "1";
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM users WHERE id = " + userInput);

        // Resource leak (SpotBugs)
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        System.out.println(reader.readLine());

        // Inefficient string concatenation in loop (PMD)
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += i;
        }

        // Weak cryptography (CodeQL)
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest("password".getBytes());

        // Deprecated API usage
        Date date = new Date();
        int year = date.getYear();

        // Empty catch block (PMD)
        try {
            int x = 10 / 0;
        } catch (Exception e) {
        }

        // Bad synchronization on non-final field
        synchronized (globalList) {
            globalList.add("unsafe");
        }

        // Dead code (PMD)
        if (false) {
            System.out.println("This will never execute");
        }

        // XSS pattern (CodeQL)
        System.out.println("<html>" + userInput + "</html>");

        // Insecure random (SpotBugs)
        Random random = new Random();
        int token = random.nextInt();

        System.out.println("Execution completed");
    }

    // equals without hashCode (SpotBugs)
    static class User {
        String name;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof User) {
                return this.name.equals(((User) obj).name);
            }
            return false;
        }
    }
}
