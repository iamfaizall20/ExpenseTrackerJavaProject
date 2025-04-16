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

    ArrayList<Expense> Expenselist = new ArrayList<>();

    static Scanner getInput = new Scanner(System.in);
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
    }

    private static void ViewAllExpenses() {
    }

    private static void DeleteExpense() {
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
    }
}




