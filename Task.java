abstract class Task {

    private int id;
    private String title;
    private String description;
    private boolean completed;

    Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

    boolean isCompleted() {
        return completed;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // This method is important for Polymorphism
    void display() {
        System.out.println(
            getId() + " - " +
            getTitle() + " - " +
            getDescription()
        );
    }
}