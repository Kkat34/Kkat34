import java.util.Scanner;

public class OddEvenChecker {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter an integer
        System.out.print("Please enter an integer: ");
        int number = scanner.nextInt();
        
        // Determine if the number is odd or even
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
        
        // Close the scanner
        scanner.close();
    }
}