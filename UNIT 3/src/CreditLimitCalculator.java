import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CreditLimitCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Number of customers
        System.out.print("Enter the number of customers: ");
        int numberOfCustomers = scanner.nextInt();
        for (int i = 0; i < numberOfCustomers; i++) {
            // Input customer details
            System.out.println("\nCustomer" + (i + 1) + ":");
            System.out.println("Account Number: ");
            int accountNumber = scanner.nextInt();
            System.out.print("Balance at the beginning of the month: ");
            int beginningBalance = scanner.nextInt();
            System.out.print("Total of all items charged by customer this month: ");
            int totalCharges = scanner.nextInt();
            System.out.print("Total of all credits applied to account this month: ");
            int totalCredits = scanner.nextInt();
            System.out.print("Allowed credit limit: ");
            int creditLimit = scanner.nextInt();

            //Calculate new balance
            int newBalance = beginningBalance + totalCharges - totalCredits;
            //Display new balance
            System.out.println("New balance for account " + accountNumber + ":" + newBalance);
            // To check if credit limit has been exceeded
            if (newBalance > creditLimit) {
                System.out.println("Credit limit exceeded.");
            } else {
                System.out.println("Credit limit not exceeded.");
            }
        }
        scanner.close();
    }
}

