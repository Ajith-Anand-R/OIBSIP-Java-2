import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int maxAttempts = 5;
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        int attempts = 0;
        boolean hasWon = false;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();

            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                continue;
            }

            attempts++;

            if (guess == targetNumber) {
                hasWon = true;
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (hasWon) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you've used all your attempts. The number was: " + targetNumber);
        }

        scanner.close();
    }
}
