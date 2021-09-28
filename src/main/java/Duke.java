import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
/*        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        String logo = "    ____________________________________________________________\n"
                + "     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + "    ____________________________________________________________\n";
        System.out.println("Hello from\n" + logo);
        String bye = "    ____________________________________________________________\n"
                + "     Bye. Hope to see you again soon!\n"
                + "    ____________________________________________________________\n";
        String line;
        String[] newString = new String[100];
        String[] newDone = new String[100];
        Arrays.fill(newDone, " ");
        int counter = 0;
        int
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
                for (int i = 1; i <= newString.length; i++)
                {
                    if (newString[i-1] != null)
                    {
                        System.out.print("     " + i + ".[" + newDone[i-1] + "] " + newString[i-1]
                                + "\n");
                    }
                }
                System.out.print("    ____________________________________________________________\n");
            }
            else if (newDone[counter].startsWith("done"))
            {
                /*String str = "abcd1234";
String[] part = str.split("(?<=\\D)(?=\\d)");
System.out.println(part[0]);
System.out.println(part[1]);


will output

abcd
1234 */
            }
            else
            {
                newString[counter] = line;
                System.out.print("    ____________________________________________________________\n"
                        + "     Added: " + newString[counter]
                        + "\n" + "    ____________________________________________________________\n");
                counter++;
            }
        }
    }
}


