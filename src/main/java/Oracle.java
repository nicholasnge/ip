import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Oracle {
    private static ArrayList<Task> db = new ArrayList<>();
    public static void main(String[] args) {
        String logo =
                "              $$$@@@@@@@\n"
                + "         ##########$$$$$$@@$\n"
                + "       #**!!!!!!!!**####$$$$$$#\n"
                + "     **!!==!=;;=;;!!!**###$$$$$$#\n"
                + "    **!!==;::~~::;;;;=!!*####$$$$##\n"
                + "   !!!!=;::~-,,,,--:;;=!!**########*\n"
                + "  !!!!=;:~,........-~:==!!**#######**\n"
                + " =!*!!=;:~,.........-:;=!!***######**\n"
                + " !***!!=:~,...     .-:;=!!****####***=\n"
                + " !*###**=;=..       -:;=!!**********!=\n"
                + ":!*###$##*=:       -:;=!!!********!!!=\n"
                + ":!##$$$$$$#*~     :;===!!*********!!=;\n"
                + "~=*#$$@@@@$$#*! ====!!!!!*****!!*!!==\n"
                + " ;!*#$$@@@$$##**!!!!!!!!!!*!*!!!!!==:\n"
                + " :;!*#$$$$$$###******!!!!!!!!!!!==;:\n"
                + "  ;!=!*#######******!!!!!!!!!===;;:,\n"
                + "   :;==!!********!!!!!!!!====;;;:~\n"
                + "    -:;!====!=!!!!!!!======;;::~,\n"
                + "      -~:;===;======;=;;;:::~-,\n"
                + "        .-~~::::;:::::~:~--.\n";
        System.out.println(logo + "\nGreetings Neo, what can the Oracle do for you?");

        Scanner S = new Scanner(System.in);
        while(true) {
            String input = S.nextLine();  // Read user input
            String[] split = input.split(" ", 2); // Split user input
            if (input.equals("bye")){
                System.out.println("Very well, we shall meet again");
                break;
            }
            else if (input.equals("list")){
                System.out.println("You have forgotten quickly, but the Oracle Remembers");
                for (int i = 0; i< db.size(); i++){
                    System.out.println((i+1) + ". " + db.get(i));
                }
            }
            else if (split[0].equals("done")){
                try {
                    int i = Integer.parseInt(split[1]) - 1;
                    db.get(i).markDone();
                    System.out.println((i+1) + ". " + db.get(i));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("The Oracle recalls you only have " + db.size() + " tasks. Give a valid index");
                }
                catch (NumberFormatException e) {
                    System.out.println("Give The Oracle the index of the done task");
                }
            }
            else if (split[0].equals("delete")){
                try {
                    int i = Integer.parseInt(split[1]) - 1;
                    Task t = db.get(i);
                    db.remove(i);
                    System.out.println("Erased: " + (i+1) + ". " + t);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("The Oracle recalls you only have " + db.size() + " tasks. Give a valid index");
                }
                catch (NumberFormatException e) {
                    System.out.println("Give The Oracle the index of the delete task");
                }
            }
            else if (split[0].equals("todo")){
                try {
                    db.add(new Todo(split[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Give The Oracle a the description of the todo");
                    continue;
                }
                System.out.println(db.size() + ". " + db.get(db.size()-1));
            }
            else if (split[0].equals("event") && split.length > 1){
                try {
                    String[] params = split[1].split("/", 2);
                    db.add(new Event(params[0], params[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Give The Oracle both the description/time of the event");
                    continue;
                }
                System.out.println(db.size() + ". " + db.get(db.size()-1));
            }
            else if (split[0].equals("deadline")){
                try {
                    String[] params = split[1].split("/", 2);
                    db.add(new Deadline(params[0], params[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Give The Oracle both the description/deadline of the deadline");
                    continue;
                }
                System.out.println(db.size() + ". " + db.get(db.size()-1));
            }
            else {
                System.out.println("Your words are unclear, Neo");
            }
        }
    }
}
