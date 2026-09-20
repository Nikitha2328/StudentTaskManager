import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/student_task_manager";

    private static final String USERNAME =
        "root";

    private static final String PASSWORD =
        System.getenv("DB_PASSWORD");

    public static Connection getConnection()
            throws Exception {

        Class.forName(
            "com.mysql.cj.jdbc.Driver"
        );

        return DriverManager.getConnection(
            URL,
            USERNAME,
            PASSWORD
        );
    }

    public static void main(String[] args) {

        try {

            Connection connection =
                getConnection();

            System.out.println(
                "Database connected successfully!"
            );

            connection.close();

        } catch (Exception e) {

            System.out.println(
                "Database connection failed!"
            );

            e.printStackTrace();
        }
    }
}