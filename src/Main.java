import java.util.ArrayList;
import java.util.Scanner;
// hazem 2/4/2025
public class Main {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    addTask(input, tasks);
                    break;
                case 2:
                    removeTask(input, tasks);
                    break;
                case 3:
                    updateTask(input, tasks);
                    break;
                case 4:
                    listTasks(tasks);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        input.close();
    }

    public static void displayMenu() {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit.");
        System.out.print("Enter your choice: ");
    }

    public static void addTask(Scanner input, ArrayList<String> tasks) {
        System.out.print("Enter task info: ");
        String info = input.nextLine();
        tasks.add(info);
        System.out.println("Task added.");
    }

    public static void removeTask(Scanner input, ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        listTasks(tasks);
        System.out.print("Enter the task number to remove: ");
        int taskNumber = input.nextInt();
        input.nextLine();
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
        } else {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed.");
        }
    }

    public static void updateTask(Scanner input, ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }
        listTasks(tasks);
        System.out.print("Enter the task number to update: ");
        int taskNumber = input.nextInt();
        input.nextLine();
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
        } else {
            System.out.print("Enter new info: ");
            String newinfo = input.nextLine();
            tasks.set(taskNumber - 1, newinfo);
            System.out.println("Task updated.");
        }
    }

    public static void listTasks(ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
