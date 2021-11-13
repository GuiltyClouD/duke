import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
/*        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo); */
        String logo = "    ____________________________________________________________\n"
                + "     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + "    ____________________________________________________________\n";
        System.out.println("Hello from\n" + logo);
        String bye = "    ____________________________________________________________\n"
                + "     Bye. Hope to see you again soon!\n"
                + "    ____________________________________________________________\n";
        String line;
        List<Task> taskList = new ArrayList<>();

        while (true)
        {
            //level 1 and 2
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            if (line.equals("bye"))
            {
                System.out.print(bye);
                break;
            }
            else if (line.equals("list"))
            {
                System.out.print("    ____________________________________________________________\n"
                        +    "     Here are the tasks in your list:\n");
                for (int i = 1; i <= taskList.size(); i++)
                {
                    System.out.print("     " + i + ". " + taskList.get(i - 1) + "\n");
                }
                System.out.print("    ____________________________________________________________\n");
            }
            else if (line.startsWith("done") && Integer.parseInt(line.substring(5)) <= taskList.size())
            {
                int tempLineNumber = Integer.parseInt(line.substring(5));
                taskList.get(tempLineNumber - 1).markAsDone();
                System.out.print("    ____________________________________________________________\n"
                        +    "     Nice! I've marked this task as done:\n");
                System.out.print("     " + "[" + taskList.get(tempLineNumber-1).getStatusIcon() + "] "
                        + taskList.get(tempLineNumber-1).getDescription() + "\n");
                System.out.print("    ____________________________________________________________\n");
            }
            /* else
            {
                Task newTask = new Task(line);
                taskList.add(newTask);
                System.out.print("    ____________________________________________________________\n"
                        + "     Added: " + newTask.getDescription()
                        + "\n" + "    ____________________________________________________________\n");
            } */
            else if (line.startsWith("todo"))
            {
                String newTask = line.substring(5);
                taskList.add(new toDo(newTask));
                System.out.print("    ____________________________________________________________\n"
                        +    "     Got it. I've added this task:\n");
                System.out.print("     " + taskList.get(taskList.size() - 1) + "\n");
                System.out.print("     Now you have " + taskList.size() + " tasks in the list.\n");
                System.out.print("    ____________________________________________________________\n");
            }
            else if (line.startsWith("deadline"))
            {
                String[] newDeadline = line.substring(9).split("/");
                String deadlineTask = newDeadline[0];
                String deadlineDate = newDeadline[1].substring(3);
                taskList.add(new Deadline(deadlineTask, deadlineDate));
                System.out.print("    ____________________________________________________________\n"
                        +    "     Got it. I've added this task:\n");
                System.out.print("     " + taskList.get(taskList.size() - 1) + "\n");
                System.out.print("     Now you have " + taskList.size() + " tasks in the list.\n");
                System.out.print("    ____________________________________________________________\n");
            }
            else if (line.startsWith("event"))
            {
                String[] newEvent = line.substring(6).split("/");
                String eventTask = newEvent[0];
                String eventDate = newEvent[1].substring(3);
                taskList.add(new Event(eventTask, eventDate));
                System.out.print("    ____________________________________________________________\n"
                        +    "     Got it. I've added this task:\n");
                System.out.print("     " + taskList.get(taskList.size() - 1) + "\n");
                System.out.print("     Now you have " + taskList.size() + " tasks in the list.\n");
                System.out.print("    ____________________________________________________________\n");
            }
        }
    }
}


