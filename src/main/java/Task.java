//level 3

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUnDone() {
        this.isDone = false;
    }

    public String getDescription()
    {
        return this.description;
    }

    @Override
    public String toString() {
        return  "["+ getStatusIcon() + "] " + getDescription();
    }
}