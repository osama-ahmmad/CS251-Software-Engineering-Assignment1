import java.util.*;


class Transaction {
    int amount;
    String type;
    String category;

    Transaction(int amount, String type, String category) {
        this.amount = amount;
        this.type = type;
        this.category = category;
    }
}

public class Main {

    static double totalIncome = 0;
    static double totalExpense = 0;

    static ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("      SMART BUDGET MANAGER");
        System.out.println("================================");

        menu();
        input.close();
    }

    // ================= MENU =================
    static void menu() {
        int choice;

        do {
            System.out.println("\n1- Add Income 💰");
            System.out.println("2- Add Expense 🧾");
            System.out.println("3- Show Report 📋");
            System.out.println("4- Search Category 🔎");
            System.out.println("5- Exit 🔚");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    showReport();
                    break;
                case 4:
                    searchCategory();
                    break;
                case 5:
                    System.out.println("Exiting... 👋");
                    break;
                default:
                    System.out.println("Invalid choice ❌");
            }

        } while (choice != 5);
    }

    // ================= ADD INCOME =================
    static void addIncome() {
        System.out.print("Enter Income Amount: ");
        int amount = input.nextInt();

        while (amount <= 0) {
            System.out.print("Enter valid amount ❌: ");
            amount = input.nextInt();
        }

        System.out.print("Enter Category: ");
        String category = input.next();

        Transaction t = new Transaction(amount, "Income", category);
        transactions.add(t);

        totalIncome += amount;

        System.out.println("✅ Income added successfully!");
    }

    // ================= ADD EXPENSE =================
    static void addExpense() {
        System.out.print("Enter Expense Amount: ");
        int amount = input.nextInt();

        while (amount <= 0) {
            System.out.print("Enter valid amount ❌: ");
            amount = input.nextInt();
        }

        System.out.print("Enter Category: ");
        String category = input.next();

        Transaction t = new Transaction(amount, "Expense", category);
        transactions.add(t);

        totalExpense += amount;

        System.out.println("✅ Expense added successfully!");
    }

    // ================= SHOW REPORT =================
    static void showReport() {

        double netBalance = totalIncome - totalExpense;

        System.out.println("\n====== BUDGET REPORT ======");
        System.out.println("Total Income  : " + totalIncome);
        System.out.println("Total Expense : " + totalExpense);
        System.out.println("Net Balance   : " + netBalance);

        System.out.println("\n--- All Transactions ---");
        for (Transaction t : transactions) {
            System.out.println(t.type + " - " + t.amount + " - " + t.category);
        }

        // Largest Expense
        int maxExpense = 0;
        String maxCategory = "";

        for (Transaction t : transactions) {
            if (t.type.equals("Expense") && t.amount > maxExpense) {
                maxExpense = t.amount;
                maxCategory = t.category;
            }
        }

        if (maxExpense > 0) {
            System.out.println("\nLargest Expense: " + maxExpense + " in " + maxCategory);
        } else {
            System.out.println("\nNo expenses recorded yet.");
        }
    }

    // ================= SEARCH =================
    static void searchCategory() {

        System.out.print("Enter Category to search 🔎: ");
        String searchCat = input.next();

        boolean found = false;

        System.out.println("\n--- Results ---");

        for (Transaction t : transactions) {
            if (t.category.equalsIgnoreCase(searchCat)) {
                System.out.println(t.type + " - " + t.amount);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found ❌");
        }
    }
}