import java.util.Scanner;

public class Main {
    static int readInteger(Scanner sc) {

    while (true) {

        try {

            return Integer.parseInt(sc.nextLine());

        } catch (NumberFormatException e) {

            System.out.println(
                "Invalid input! Please enter a number."
            );
        }
    }
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskDAO dao = new TaskDAO();

        TaskManager manager = new TaskManager();

        manager.loadTasks();

        while (true) {

            System.out.println();
            System.out.println(
                "===== Student Task Manager ====="
            );

            System.out.println(
                "Total Tasks: " +
                TaskManager.getTotalTasks()
            );

            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Edit Task");
            System.out.println("7. Exit");

           System.out.print("Enter your choice: ");

            int choice = readInteger(sc);

            if (choice == 1) {

              System.out.print("Enter Task ID: ");

              int id = readInteger(sc);

                

             

                if (id <= 0) {
                   System.out.println(
                      "Task ID must be greater than 0!"
                    );
                    continue;
                }

                System.out.print("Enter Task Title: ");
                String title = sc.nextLine();

                if (title.trim().isEmpty()) {
                    System.out.println(
                        "Task title cannot be empty!"
                    );
                    continue;
                }

                System.out.print(
                    "Enter Task Description: "
                );

                String description =
                    sc.nextLine();

                if (description.trim().isEmpty()) {
                    System.out.println(
                        "Task description cannot be empty!"
                    );
                    continue;
                }

                // Polymorphism
                Task task = new StudyTask(
                    id,
                    title,
                    description,
                    "Java"
                );

                dao.addTask(task);

            } else if (choice == 2) {

                dao.viewTasks();

            } else if (choice == 3) {

                System.out.print(
                    "Enter Task ID to complete: "
                );

                int id = readInteger(sc);

                dao.completeTask(id);

            } else if (choice == 4) {

                System.out.print(
                    "Enter Task ID to delete: "
                );

                int id = readInteger(sc);

                dao.deleteTask(id);
            } else if (choice == 5) {

                System.out.print(
                    "Enter keyword to search: "
                );

                String keyword = sc.nextLine();

                dao.searchTask(keyword);

            } else if (choice == 6) {

                System.out.print(
                     "Enter Task ID to edit: "
                );

                int id = readInteger(sc);
                System.out.print(
                    "Enter new title: "
                );

                String newTitle =
                    sc.nextLine();

                if (newTitle.trim().isEmpty()) {
                    System.out.println(
                        "Title cannot be empty!"
                    );
                    continue;
                }

                System.out.print(
                    "Enter new description: "
                );

                String newDescription =
                    sc.nextLine();

                if (newDescription.trim().isEmpty()) {
                    System.out.println(
                        "Description cannot be empty!"
                    );
                    continue;
                }

                dao.editTask(
                    id,
                    newTitle,
                    newDescription
                );

            } else if (choice == 7) {

                manager.saveTasks();

                System.out.println("Thank you!");

                break;

            } else {

                System.out.println(
                    "Invalid choice!"
                );
            }
        }

        sc.close();
    }
}