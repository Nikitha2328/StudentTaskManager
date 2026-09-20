import java.sql.Connection;
import java.sql.PreparedStatement;

public class TaskDAO {

    public void addTask(Task task) {

        String sql =
            "INSERT INTO tasks (id, title, description, completed) " +
            "VALUES (?, ?, ?, ?)";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement =
                connection.prepareStatement(sql)
        ) {

            statement.setInt(1, task.getId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());

            statement.executeUpdate();

            System.out.println(
                "Task saved to MySQL successfully!"
            );

        } catch (Exception e) {

            System.out.println(
                "Error saving task to database!"
            );

            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    TaskDAO dao = new TaskDAO();

    dao.searchTask("Java");
}
public void viewTasks() {

    String sql = "SELECT * FROM tasks";

    try (
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =
            connection.prepareStatement(sql)
    ) {

        var result = statement.executeQuery();

        while (result.next()) {

            System.out.println(
                result.getInt("id") + " - " +
                result.getString("title") + " - " +
                result.getString("description") + " - " +
                result.getBoolean("completed")
            );
        }

    } catch (Exception e) {

        System.out.println(
            "Error loading tasks from database!"
        );

        e.printStackTrace();
    }
}
public void completeTask(int id) {

    String sql =
        "UPDATE tasks SET completed = true WHERE id = ?";

    try (
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =
            connection.prepareStatement(sql)
    ) {

        statement.setInt(1, id);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Task completed successfully!");
        } else {
            System.out.println("Task not found!");
        }

    } catch (Exception e) {

        System.out.println(
            "Error completing task!"
        );

        e.printStackTrace();
    }
}
public void deleteTask(int id) {

    String sql = "DELETE FROM tasks WHERE id = ?";

    try (
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =
            connection.prepareStatement(sql)
    ) {

        statement.setInt(1, id);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found!");
        }

    } catch (Exception e) {

        System.out.println(
            "Error deleting task!"
        );

        e.printStackTrace();
    }
}
public void editTask(
        int id,
        String newTitle,
        String newDescription) {

    String sql =
        "UPDATE tasks SET title = ?, description = ? WHERE id = ?";

    try (
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =
            connection.prepareStatement(sql)
    ) {

        statement.setString(1, newTitle);
        statement.setString(2, newDescription);
        statement.setInt(3, id);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Task not found!");
        }

    } catch (Exception e) {

        System.out.println(
            "Error updating task!"
        );

        e.printStackTrace();
    }
}
public void searchTask(String keyword) {

    String sql =
        "SELECT * FROM tasks " +
        "WHERE title LIKE ? OR description LIKE ?";

    try (
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =
            connection.prepareStatement(sql)
    ) {

        String search = "%" + keyword + "%";

        statement.setString(1, search);
        statement.setString(2, search);

        var result = statement.executeQuery();

        boolean found = false;

        while (result.next()) {

            System.out.println(
                result.getInt("id") + " - " +
                result.getString("title") + " - " +
                result.getString("description") + " - " +
                result.getBoolean("completed")
            );

            found = true;
        }

        if (!found) {
            System.out.println("No matching task found!");
        }

    } catch (Exception e) {

        System.out.println(
            "Error searching tasks!"
        );

        e.printStackTrace();
    }
}
}