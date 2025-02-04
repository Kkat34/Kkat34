//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(1000) + 1;
            int playerGuess = 0;

            System.out.println("Guess a number between 1 and 1000.");

            while (playerGuess != numberToGuess) {
                playerGuess = scanner.nextInt();

                if (playerGuess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else if (playerGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                }
            }
            System.out.println("Congratulations. You guessed the number!");

            System.out.println("Do you want to play again? (true/false)");
            playAgain = scanner.nextBoolean();
        } while (playAgain);
        scanner.close();

    }
}