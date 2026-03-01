import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        int nextId = 1;
        int choice = 0;

        while (choice != 5) {

            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Enter task title: ");
                String title = input.nextLine();

                System.out.print("Enter due date: ");
                String dueDate = input.nextLine();

                System.out.println("Select priority:");
                System.out.println("1. Low");
                System.out.println("2. Medium");
                System.out.println("3. High");

                System.out.print("Enter number (1-3): ");
                int priority = input.nextInt();
                input.nextLine();

                if (priority < 1 || priority > 3) {
                    System.out.println("Invalid priority. Setting to Low.");
                    priority = 1;
                }

                Task t = new Task(nextId, title, dueDate, priority, false);
                tasks.add(t);
                nextId++;

                System.out.println("Task added!");
            }

            else if (choice == 2) {

                if (tasks.size() == 0) {
                    System.out.println("No tasks available.");
                } else {
                    
                    tasks.sort((t1, t2) -> t2.getPriorityValue() - t1.getPriorityValue());

                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(tasks.get(i));
                    }
                }
            }

            else if (choice == 3) {

                System.out.print("Enter task ID: ");
                int id = input.nextInt();
                input.nextLine();

                boolean found = false;

                for (Task t : tasks) {
                    if (t.id == id) {
                        t.isCompleted();
                        found = true;
                        System.out.println("Task marked as done!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Task not found.");
                }
            }

            else if (choice == 4) {

                System.out.print("Enter task ID to delete: ");
                int id = input.nextInt();
                input.nextLine();

                boolean removed = false;

                for (int i = 0; i < tasks.size(); i++) {
                    if (tasks.get(i).id == id) {
                        tasks.remove(i);
                        removed = true;
                        System.out.println("Task deleted!");
                        break;
                    }
                }
                if (!removed) {
                    System.out.println("Task not found.");
                }
            }
        }
        input.close();
        System.out.println("Goodbye!");
    }
}