import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.Statement;

public class CodeQLTest {

    public void test(HttpServletRequest request, Connection connection) throws Exception {

        String user = request.getParameter("user");

        Statement stmt = connection.createStatement();

        // SQL injection with tainted input
        String query = "SELECT * FROM users WHERE name = '" + user + "'";

        stmt.executeQuery(query);
    }
}
