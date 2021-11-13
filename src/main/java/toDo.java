//level 4

public class toDo extends Task {

    protected String by;

    public toDo(String description) {
        super(description);
        this.description = description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}