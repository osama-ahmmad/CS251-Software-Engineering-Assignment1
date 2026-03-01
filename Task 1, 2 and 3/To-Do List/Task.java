public class Task {
    int id, priority;
    String title, dueDate;
    boolean completed;

    public Task(int id, String title, String dueDate, int priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
    }

    public void isCompleted() {
        completed = true;
    }

    public String toFileString() {
        return id + "," + title + "," + dueDate + "," + priority + "," + completed;
    }

    public int getPriorityValue() {
        return priority;
    }

    public String getPriorityText() {

        if (priority == 3) {
            return "High";
        } else if (priority == 2) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    public String toString() {
        String status;
        if (completed) {
            status = "Done";
        } else {
            status = "Not Done";
        }
        return id + ". " + title + " | Due: " + dueDate + " | Priority: " + getPriorityText() + " | Status: " + status;
    }

}
