import java.sql.*;

public class DBConnect{
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\users.db");
        if(connection != null) {
            System.out.println("Connected");
        }
        Statement statement = connection.createStatement();
        String query = "SELECT * from users";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()) {
            System.out.println(rs.getString("id") + " " +
                    rs.getString("login") + " " +
                    rs.getString("password") + " " +
                    rs.getString("nick"));
        }
    }

}
