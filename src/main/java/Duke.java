import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    static String verifyToDo (String task) throws DukeException{
        String[] toDoTask = task.split(" ");
        StringBuilder result = new StringBuilder();
        if (toDoTask.length < 2)
        {
            System.out.println("    ____________________________________________________________\n");
            throw new DukeException("     ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        for (String word : toDoTask){
            result.append(word).append(" ");
        }
        return result.substring(5).trim();
    }

    public static void main(String[] args) throws DukeException{
        String logo = "    ____________________________________________________________\n"
                + "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n"
                + "     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + "    ____________________________________________________________\n";
        System.out.println("Hello from\n" + logo);
        String bye = "    ____________________________________________________________\n"
                + "     Bye. Hope to see you again soon!\n"
                + "    ____________________________________________________________\n";
        String line;  //input from user
        List<Task> taskList = new ArrayList<>();

        while (true)
        {
            try {
                //level 1 and 2
                Scanner in = new Scanner(System.in);
                line = in.nextLine();
                if (line.equals("bye")) {
                    System.out.print(bye);
                    break;
                } else if (line.equals("list")) {
                    System.out.print("    ____________________________________________________________\n"
                            + "     Here are the tasks in your list:\n");
                    for (int i = 1; i <= taskList.size(); i++) {
                        System.out.print("     " + i + ". " + taskList.get(i - 1) + "\n");
                    }
                    System.out.print("    ____________________________________________________________\n");
                } else if (line.startsWith("done") && Integer.parseInt(line.substring(5)) <= taskList.size()) {
                    int tempLineNumber = Integer.parseInt(line.substring(5));
                    taskList.get(tempLineNumber - 1).markAsDone();
                    System.out.print("    ____________________________________________________________\n"
                            + "     Nice! I've marked this task as done:\n");
                    System.out.print("     " + "[" + taskList.get(tempLineNumber - 1).getStatusIcon() + "] "
                            + taskList.get(tempLineNumber - 1).getDescription() + "\n");
                    System.out.print("    ____________________________________________________________\n");
                }
                else if (line.startsWith("undone") && Integer.parseInt(line.substring(7)) <= taskList.size()) {
                    int tempLineNumber = Integer.parseInt(line.substring(7));
                    taskList.get(tempLineNumber - 1).markAsUnDone();
                    System.out.print("    ____________________________________________________________\n"
                            + "     Nice! I've marked this task as undone:\n");
                    System.out.print("     " + "[" + taskList.get(tempLineNumber - 1).getStatusIcon() + "] "
                            + taskList.get(tempLineNumber - 1).getDescription() + "\n");
                    System.out.print("    ____________________________________________________________\n");
                }
                else if (line.startsWith("delete") && Integer.parseInt(line.substring(7)) <= taskList.size()) {
                    int tempLineNumber = Integer.parseInt(line.substring(7));
                    System.out.print("    ____________________________________________________________\n"
                            + "     Noted. I've removed this task:\n");
                    System.out.print("     " + taskList.get(tempLineNumber - 1) + "\n");
                    //System.out.print("     " + "[" + taskList.get(tempLineNumber - 1).getStatusIcon() + "] "
                            //+ taskList.get(tempLineNumber - 1).getDescription() + "\n");
                    taskList.remove(tempLineNumber - 1);
                    System.out.print("     Now you have" + " " + taskList.size() + " " + "tasks in the list.\n");
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
                else if (line.startsWith("todo")) {
                    String newTask = verifyToDo(line);
                    taskList.add(new toDo(newTask));
                    System.out.print("    ____________________________________________________________\n"
                            + "     Got it. I've added this task:\n");
                    System.out.print("     " + taskList.get(taskList.size() - 1) + "\n");
                    System.out.print("     Now you have " + taskList.size() + " tasks in the list.\n");
                    System.out.print("    ____________________________________________________________\n");
                } else if (line.startsWith("deadline")) {
                    String[] newDeadline = line.substring(9).split("/");
                    String deadlineTask = newDeadline[0];
                    String deadlineDate = newDeadline[1].substring(3);
                    taskList.add(new Deadline(deadlineTask, deadlineDate));
                    System.out.print("    ____________________________________________________________\n"
                            + "     Got it. I've added this task:\n");
                    System.out.print("     " + taskList.get(taskList.size() - 1) + "\n");
                    System.out.print("     Now you have " + taskList.size() + " tasks in the list.\n");
                    System.out.print("    ____________________________________________________________\n");
                } else if (line.startsWith("event")) {
                    String[] newEvent = line.substring(6).split("/");
                    String eventTask = newEvent[0];
                    String eventDate = newEvent[1].substring(3);
                    taskList.add(new Event(eventTask, eventDate));
                    System.out.print("    ____________________________________________________________\n"
                            + "     Got it. I've added this task:\n");
                    System.out.print("     " + taskList.get(taskList.size() - 1) + "\n");
                    System.out.print("     Now you have " + taskList.size() + " tasks in the list.\n");
                    System.out.print("    ____________________________________________________________\n");
                } else {
                    System.out.print("    ____________________________________________________________\n");
                    throw new DukeException("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e)
            {
                System.out.println(e);
                System.out.print("    ____________________________________________________________\n");
            }
        }
    }
    //writing and implementing save file function, not completed. Trying to understand and implement it
    public static void saveTask(String command,String task) throws IOException {
        String filePath = "dukeMyTask.txt";
        File f = new File(filePath);
        FileWriter fw = new FileWriter(filePath);
        fw.write(command + " || " + task);
        fw.close();
        try {
            boolean result = f.createNewFile();
            Scanner s = new Scanner(f);
            System.out.println("Load data from file ++++ ");
            while (s.hasNext()) {
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


