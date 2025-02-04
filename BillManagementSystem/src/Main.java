import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    List<Bill> bills = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String choice;
    do {
        System.out.println("Select bill type: 1. Mortgage 2. CreditCard 3. ElectricBill 4. Exit");
        choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter vendor: ");
                String vendor1 = scanner.nextLine();
                System.out.print("Enter principal: ");
                double principal = scanner.nextDouble();
                System.out.print("Enter interest: ");
                double interest = scanner.nextDouble();
                System.out.print("Enter taxes: ");
                double taxes = scanner.nextDouble();
                System.out.print("Enter insurance: ");
                double insurance = scanner.nextDouble();
                bills.add(new Mortgage(vendor1, principal, interest, taxes, insurance));
                scanner.nextLine(); // consume newline
                break;

            case "2":
                System.out.print("Enter vendor: ");
                String vendor2 = scanner.nextLine();
                System.out.print("Enter charges: ");
                double charges = scanner.nextDouble();
                System.out.print("Enter credits: ");
                double credits = scanner.nextDouble();
                bills.add(new CreditCard(vendor2, charges, credits));
                scanner.nextLine(); // consume newline
                break;

            case "3":
                System.out.print("Enter vendor: ");
                String vendor3 = scanner.nextLine();
                System.out.print("Enter base charge: ");
                double baseCharge = scanner.nextDouble();
                System.out.print("Enter cost per kWh: ");
                double costPerKWh = scanner.nextDouble();
                System.out.print("Enter kWh consumed: ");
                double kWhConsumed = scanner.nextDouble();
                bills.add(new ElectricBill(vendor3, baseCharge, costPerKWh, kWhConsumed));
                scanner.nextLine(); // consume newline
                break;

            case "4":
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (!choice.equals("4"));

    double totalSum = 0;
        for (Bill bill : bills) {
        System.out.println(bill);
        totalSum += bill.getPaymentAmount();
    }
        System.out.println("Total sum of all bills: " + totalSum);
        scanner.close();
}
}
