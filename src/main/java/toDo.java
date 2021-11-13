//level 4

public class toDo extends Task {

    protected String by;

    public toDo(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString() + " (by: " + by + ")";
    }
}