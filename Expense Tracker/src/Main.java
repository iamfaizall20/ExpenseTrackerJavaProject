import java.util.ArrayList;
import java.util.Scanner;

class Expense{
    double Amount;
    String Description;
    String Category;
    String Date;

    public Expense(double amount, String description, String category, String date) {
        Amount = amount;
        Description = description;
        Category = category;
        Date = date;
    }
}

public class Main {

    public static final String REDCOLOR = "\033[31m";
    public static final String RESETCOLOR = "\033[0m";
    public static final String GREENCOLOR = "\033[32m";
    public static final String PURPLECOLOR = "\033[35m";
    public static final String BLUECOLOR = "\033[34m";

    static Expense[] expenselist = new Expense[150];


    static Scanner getInput = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Pull Requested");
        while (true) {
            System.out.print(PURPLECOLOR);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║            ~ EXPENSE TRACKER ~             ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(RESETCOLOR);
            System.out.println(GREENCOLOR + "☰ " + "MENU" + RESETCOLOR + " - ENTER YOUR CHOICE");
            System.out.printf("%-22s%-22s%n", "1.➕ Add Expense", "2.📋 View All Expenses");
            System.out.printf("%-24s%-23s%n", "3.🗑️ Delete Expense", "4.🧹 Clear All Expenses");
            System.out.printf("%-23s%-23s%n", "5.📅 Filter By Date", "6.🔍 Filter By Category");
            System.out.printf("%-23s%-23s%n", "7.📋 View Summary  ", "8.💰 Show Total Expenses");
            System.out.printf("%-23s%n","9.❌ Exit");
            System.out.print(PURPLECOLOR + "(→) " + RESETCOLOR);

            int choice = getInput.nextInt();

            if(choice >= 1 && choice <= 9){
                switch (choice){
                    case 1: AddExpense(); break;
                    case 2: ViewAllExpenses(); break;
                    case 3: DeleteExpense(); break;
                    case 4: ClearAllExpenses(); break;
                    case 5: FilterByCategory(); break;
                    case 6: FilterByDate(); break;
                    case 7: ViewSummary(); break;
                    case 8: TotalExpense(); break;
                    case 9: System.out.println("😊 Thanks for using EXPENSE TRACKER"); return;
                }
            }else{
                System.out.println("❌"+REDCOLOR+" Invalid Choice!,Try Again"+RESETCOLOR);
            }
        }

    }

    private static void AddExpense() {
        for (int i = 0; i < expenselist.length; i++){
          if (expenselist[i] == null){
              System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Amount: ");
              double amount = getInput.nextDouble();
              getInput.nextLine();

              System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Description: ");
              String description = getInput.nextLine();

              System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Category: ");
              String category = getInput.nextLine();

              System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Date (dd-mm-yyyy): ");
              String date = getInput.nextLine();

              expenselist[i] = new Expense(amount, description, category, date);

              System.out.println(GREENCOLOR + "Expense Added Successfully!" + RESETCOLOR);
              return;
          }
        }
        System.out.println("Expense list is full");
    }

    private static void ViewAllExpenses() {
        boolean hasExpenses = false;

        System.out.println(PURPLECOLOR + "\n╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         All Recorded Expenses                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝" + RESETCOLOR);

        System.out.printf("%-8s %-10s %-20s %-15s %-15s%n",
                GREENCOLOR + "S. No", "   Amount", "   Description", "   Category", "   1Date" + RESETCOLOR);
        System.out.println("------------------------------------------------------------------------");

        for (int i = 0; i < expenselist.length; i++) {
            if (expenselist[i] != null) {
                Expense exp = expenselist[i];
                System.out.printf("%-8d 1%-9.2f %-20s %-15s %-15s%n",
                        i+1, exp.Amount, exp.Description, exp.Category, exp.Date);
                hasExpenses = true;
            }
        }

        if (!hasExpenses) {
            System.out.println(REDCOLOR + "No expenses to show!" + RESETCOLOR);
        }
    }

    private static void DeleteExpense() {
        boolean found = false;

        for (int i = 0; i < expenselist.length; i++) {
            if (expenselist[i] != null) {
                System.out.println(i + ". " + expenselist[i].Description + " - " + expenselist[i].Amount);
                found = true;
            }
        }

        if (!found) {
            System.out.println(REDCOLOR + "No expenses to delete." + RESETCOLOR);
            return;
        }

        System.out.print("Enter the index number to delete: ");
        int index = getInput.nextInt();

        if (index >= 0 && index < expenselist.length && expenselist[index] != null) {
            expenselist[index] = null;
            System.out.println(GREENCOLOR + "Expense deleted successfully!" + RESETCOLOR);
        } else {
            System.out.println(REDCOLOR + "Invalid index or empty slot!" + RESETCOLOR);
        }
    }

    private static void ClearAllExpenses() {
    }

    private static void FilterByCategory() {
    }

    private static void FilterByDate() {
    }

    private static void ViewSummary() {
    }

    private static void TotalExpense() {
        double total = 0;

        for (Expense exp : expenselist){
            if (exp != null){
                total += exp.Amount;
            }
        }
        System.out.println(PURPLECOLOR + "\n╔═══════════════════════════════╗");
        System.out.println("║        TOTAL EXPENSES         ║");
        System.out.println("╚═══════════════════════════════╝" + RESETCOLOR);
        System.out.printf(GREENCOLOR + "💰 Total: %.2f\n" + RESETCOLOR, total);

    }
    //Comment

}




