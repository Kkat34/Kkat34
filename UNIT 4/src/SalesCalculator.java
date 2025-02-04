import java.util.Scanner;
public class SalesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalSales = 0.0;
        int productNumber;
        int quantitySold;

        while (true) {
            System.out.print("Enter product number(1-5) or 0 to exit: ");
            productNumber = scanner.nextInt();
            if (productNumber == 0) {
                break;
            }
            System.out.print("Enter quantity sold: ");
            quantitySold = scanner.nextInt();

            double price;
            switch (productNumber) {
                case 1:
                    price = 2.98;
                    break;
                case 2:
                    price = 4.50;
                    break;
                case 3:
                    price = 9.98;
                    break;
                case 4:
                    price = 4.49;
                    break;
                case 5:
                    price = 6.87;
                    break;
                default:
                    System.out.println("Invalid product number.");
                    continue;
            }
            totalSales += price * quantitySold;
        }

        System.out.printf("Total retail value of all products sold: $%.2f%n", totalSales);
        scanner.close();
    }
}
