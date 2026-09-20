interface TaskOperations {

    void addTask(Task task);

    void viewTasks();

    void completeTask(int id);

    void deleteTask(int id);

    void searchTask(String keyword);

    void editTask(
            int id,
            String newTitle,
            String newDescription
    );
}