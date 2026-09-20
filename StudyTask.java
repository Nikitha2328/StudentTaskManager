class StudyTask extends Task {

    private String subject;

    StudyTask(
            int id,
            String title,
            String description,
            String subject) {

        super(id, title, description);

        this.subject = subject;
    }

    String getSubject() {
        return subject;
    }

    @Override
    void display() {

        System.out.println(
            getId() + " - " +
            getTitle() + " - " +
            getDescription()
        );

        System.out.println(
            "Subject: " + subject
        );
    }
}