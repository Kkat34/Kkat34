import java.util.Scanner;

public class NumberOperations {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for three integers
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Enter the third integer: ");
        int num3 = scanner.nextInt();
        
        // Calculate sum, average, product, smallest, and largest
        int sum = num1 + num2 + num3;
        double average = sum / 3.0; // Use 3.0 to ensure double division
        int roundedAverage = (int) Math.round(average); // Round to nearest integer
        int product = num1 * num2 * num3;
        
        // Find the smallest and largest numbers
        int smallest = num1;
        int largest = num1;
        
        if (num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }
        
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }
        
        // Display the results
        System.out.println("Sum: " + sum);
        System.out.println("Average(rounded): " + roundedAverage);
        System.out.println("Product: " + product);
        System.out.println("Smallest: " + smallest);
        System.out.println("Largest: " + largest);
        
        // Close the scanner
        scanner.close();
    }
}