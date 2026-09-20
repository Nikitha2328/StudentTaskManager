import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class TaskManager implements TaskOperations {

    private final ArrayList<Task> tasks = new ArrayList<>();

    private static int totalTasks = 0;

    static int getTotalTasks() {
        return totalTasks;
    }
    Task findTaskById(int id) {

    for (Task task : tasks) {

        if (task.getId() == id) {
            return task;
        }
    }

    return null;
}

    // Add Task
    public void addTask(Task task) {

        for (Task existingTask : tasks) {

            if (existingTask.getId() == task.getId()) {
                System.out.println("Task ID already exists!");
                return;
            }
        }

        tasks.add(task);
        totalTasks++;

        System.out.println("Task added successfully!");
    }

    // View Tasks
    public void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {

            task.display();

            String status = task.isCompleted()
                    ? "Completed"
                    : "Pending";

            System.out.println("Status: " + status);
            System.out.println();
        }
    }

   // Complete Task
public void completeTask(int id) {

    Task task = findTaskById(id);

    if (task != null) {

        task.setCompleted(true);

        System.out.println(
            "Task completed successfully!"
        );

    } else {

        System.out.println(
            "Task not found!"
        );
    }
}
    // Delete Task
public void deleteTask(int id) {

    Task task = findTaskById(id);

    if (task != null) {

        tasks.remove(task);
        totalTasks--;

        System.out.println(
            "Task deleted successfully!"
        );

    } else {

        System.out.println(
            "Task not found!"
        );
    }
}

    // Search Task
public void searchTask(String keyword) {

    boolean found = false;

    String searchKeyword =
        keyword.toLowerCase().trim();

    for (Task task : tasks) {

        boolean titleMatch =
            task.getTitle()
                .toLowerCase()
                .contains(searchKeyword);

        boolean descriptionMatch =
            task.getDescription()
                .toLowerCase()
                .contains(searchKeyword);

        if (titleMatch || descriptionMatch) {

            task.display();

            String status = task.isCompleted()
                    ? "Completed"
                    : "Pending";

            System.out.println(
                "Status: " + status
            );

            System.out.println();

            found = true;
        }
    }

    if (!found) {

        System.out.println(
            "No matching task found!"
        );
    }
}

   // Edit Task
public void editTask(
        int id,
        String newTitle,
        String newDescription) {

    Task task = findTaskById(id);

    if (task != null) {

        task.setTitle(newTitle);
        task.setDescription(newDescription);

        System.out.println(
            "Task updated successfully!"
        );

    } else {

        System.out.println(
            "Task not found!"
        );
    }
}

    // Save Tasks
    void saveTasks() {

        try (FileWriter writer =
                new FileWriter("tasks.txt")) {

            for (Task task : tasks) {

                writer.write(
                    task.getId() + "," +
                    task.getTitle() + "," +
                    task.getDescription() + "," +
                    task.isCompleted() + "\n"
                );
            }

            System.out.println(
                "Tasks saved successfully!"
            );

        } catch (IOException e) {

            System.out.println(
                "Error saving tasks!"
            );
        }
    }

    // Load Tasks
    void loadTasks() {

        try (
            FileReader reader =
                new FileReader("tasks.txt");

            BufferedReader br =
                new BufferedReader(reader)
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length < 4) {
                    continue;
                }

                int id =
                    Integer.parseInt(data[0]);

                String title = data[1];

                String description = data[2];

                boolean completed =
                    Boolean.parseBoolean(data[3]);

                Task task = new StudyTask(
                    id,
                    title,
                    description,
                    "Java"
                );

                task.setCompleted(completed);

                tasks.add(task);
                totalTasks++;
            }

        } catch (IOException e) {

            System.out.println(
                "No saved tasks found."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                "Invalid data found in tasks file."
            );
        }
    }
}