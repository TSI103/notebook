package javacourses;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Record> records = new ArrayList<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        System.out.println("This is your personal notebook. Enter 'help' for all available commands");
        for (; ; ) {
            String cmd = askString("cmd> ");

            switch (cmd.toLowerCase()) {
                case "exit":
                    return;
                case "create":
                    create();
                    break;
                case "find":
                    find();
                    break;
                case "list":
                    list();
                    break;
                case "help":
                    showHelp();
                    break;
                default:
                    System.out.println("Unknown command. Enter 'help' for all available options");
            }
        }
    }

    private static void list() {
        for (Record r : records) {
            System.out.println(r);
        }
    }

    private static void find() {
        String part = askString("What to find? ");
        for (Record r : records) {
            if (r.contains(part)) {
                System.out.println(r);
            }
        }
    }

    private static void create() {
        for (; ; ) {
            System.out.println("Enter type of the record to create. 'help' for all available options");
            String type = askString("type: ");

            switch (type.toLowerCase()) {
                case "exit":
                    return;
                case "person":
                    addRecord(new Person());
                    return;
                case "note":
                    addRecord(new Note());
                    return;
                case "help":
                    showHelpCreate();
                    break;
                default:
                    System.out.println("Unknown type");
            }
        }
    }

    private static void addRecord(Record record) {
        record.askUserData();
        records.add(record);
        System.out.println("Created!");
    }

    private static void showHelpCreate() {
        System.out.println("\tperson  creates a new phone book record");
        System.out.println("\tlist    list all created records");
        System.out.println("\texit    returns to main menu");
    }

    private static void showHelp() {
        System.out.println("\thelp    shows this help");
        System.out.println("\tcreate  creates a new record");
        System.out.println("\texit    exit from the program");
    }

    public static String askString(String message) {
        System.out.print(message);
        String str = scanner.next();
        if (str.startsWith("\"")) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            while (!str.endsWith("\"")) {
                str = scanner.next();
                list.add(str);
            }
            str = String.join(" ", list);
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }
}
