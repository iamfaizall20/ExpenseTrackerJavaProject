import java.util.InputMismatchException;
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

    static Scanner getInput = new Scanner(System.in);

    static Expense[] expenselist = new Expense[150];

    public static void main(String[] args) {
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
              double amount = 0.0;
              boolean validInput = false;

              while (!validInput) {
                  System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Amount: ");
                  try {
                      amount = getInput.nextDouble();
                      getInput.nextLine();
                      validInput = true;
                  } catch (InputMismatchException e) {
                      System.out.println(REDCOLOR + "Invalid input! Please enter a number." + RESETCOLOR);
                      getInput.nextLine();
                  }
              }
              System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Description: ");
              String description = getInput.nextLine();

              System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Category: ");
              String category = getInput.nextLine();

              System.out.print(BLUECOLOR + "(→) " + RESETCOLOR + " Date (dd-mm-yyyy): ");
              String date = getInput.nextLine();

              expenselist[i] = new Expense(amount, description, category, date);

              System.out.println(GREENCOLOR + "\nExpense Added Successfully!" + RESETCOLOR);
              return;
          }
        }
        System.out.println("Expense list is full");
    }

    private static void ViewAllExpenses() {

        System.out.println(PURPLECOLOR);
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                   All Recorded Expenses                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESETCOLOR);

        if (expenselist[0] == null) {
            System.out.println(REDCOLOR + "No expenses to show!" + RESETCOLOR);
            return;
        }

        System.out.println("╔══════╦══════════╦══════════════════╦══════════╦════════════╗");
        System.out.printf("║ %-4s ║ %-8s ║ %-16s ║ %-8s ║ %-10s ║%n",
                "No", "Amount", "Description", "Category", "Date");
        System.out.println("╠══════╬══════════╬══════════════════╬══════════╬════════════╣");

        for (int i = 0; i < expenselist.length; i++) {
            if (expenselist[i] != null) {
                System.out.printf("║ %-4d ║ %-8.2f ║ %-16s ║ %-8s ║ %-10s ║%n",
                        i + 1,
                        expenselist[i].Amount,
                        expenselist[i].Description,
                        expenselist[i].Category,
                        expenselist[i].Date);
            }
        }

        System.out.println("╚══════╩══════════╩══════════════════╩══════════╩════════════╝");
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

        for (Expense exp : expenselist) {
            if (exp != null) {
                total += exp.Amount;
            }
        }
        System.out.println(PURPLECOLOR + "\n╔═══════════════════════════════╗");
        System.out.println("║        TOTAL EXPENSES         ║");
        System.out.println("╚═══════════════════════════════╝" + RESETCOLOR);
        System.out.printf(GREENCOLOR + "💰 Total: %.2f\n" + RESETCOLOR, total);

    }
    //Comment
    //Rajiv Sachdev
}




