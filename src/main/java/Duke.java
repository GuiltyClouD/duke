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
        int tempStoreSplitNumber = 0;
        int counter = 0;
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
                    System.out.print("     " + i + ".[" + taskList.get(i-1).getStatusIcon() + "] "
                                + taskList.get(i-1).getDescription() + "\n");
                }
                System.out.print("    ____________________________________________________________\n");
            }
            else if (line.substring(0,4).equals("done") && Integer.parseInt(line.substring(5)) <= taskList.size())
            {
                int tempLineNumber = Integer.parseInt(line.substring(5));
                taskList.get(tempLineNumber - 1).markAsDone();
                System.out.print("    ____________________________________________________________\n"
                        +    "     Nice! I've marked this task as done:\n");
                System.out.print("     " + "[" + taskList.get(tempLineNumber-1).getStatusIcon() + "] "
                        + taskList.get(tempLineNumber-1).getDescription() + "\n");
                System.out.print("    ____________________________________________________________\n");
            }
            else
            {
                Task newTask = new Task(line);
                taskList.add(newTask);
                System.out.print("    ____________________________________________________________\n"
                        + "     Added: " + newTask.getDescription()
                        + "\n" + "    ____________________________________________________________\n");
            }
        }
    }
}


