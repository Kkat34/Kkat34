
import java.util.Scanner;

public class SalesSummary {
    public static void main(String[] args) {
        // Constants for salespeople and products
        final int NUM_SALESPERSONS = 4;
        final int NUM_PRODUCTS = 5;

        //2D array to store sales data
        double[][] sales = new double[NUM_PRODUCTS][NUM_SALESPERSONS];

        //Scanner for input
        Scanner scanner = new Scanner(System.in);

        //Input sales data
        System.out.println("Enter sales data for last month(salesperson product value). Type 'exit' to finish:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid input. Please enter in the format: salesperson product value");
                continue;
            }
            try {
                int salesperson = Integer.parseInt(parts[0]) - 1; //Convert to 0-based index
                int product = Integer.parseInt(parts[1]) - 1; //Convert to 0-based index
                double value = Double.parseDouble(parts[2]);

                //Update the sales array
                if (salesperson >= 0 && salesperson < NUM_SALESPERSONS && product >= 0 && product < NUM_PRODUCTS) {
                    sales[product][salesperson] += value;
                } else {
                    System.out.println("Salesperson or product number out of range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please try again.");
                }
            }
            //Close the scanner
            scanner.close();
            //Calculate totals
            double[] productTotals = new double[NUM_PRODUCTS];
            double[] salespersonTotals = new double[NUM_SALESPERSONS];

            //Display the sales data in tabular format
            System.out.printf("%-10s", "Product/Salesperson");
            for (int i = 1; i <= NUM_SALESPERSONS; i++) {
                System.out.printf("%-10s", "Salesperson" + i);
            }
            System.out.printf("%-10s%n", "Total");

            for (int i = 0; i < NUM_PRODUCTS; i++) {
                System.out.printf("%-10s", "Product " + (i + 1));
                for (int j = 0; j < NUM_SALESPERSONS; j++) {
                    System.out.printf("%-10.2f", sales[i][j]);
                    productTotals[i] += sales[i][j];
                    salespersonTotals[j] += sales[i][j]; // Update salesperson totals
                }
                System.out.printf("%-10.2f%n", productTotals[i]);
            }
            //Display salesperson totals
            System.out.printf("%-10s", "Total");
            for (int j = 0; j< NUM_SALESPERSONS; j++) {
                System.out.printf("%-10.2f", salespersonTotals[j]);
            }
            System.out.println();
        }
    }