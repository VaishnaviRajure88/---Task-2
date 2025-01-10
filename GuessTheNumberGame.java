import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("Guess the number between 1 and 100.");

        boolean playAgain = true;
        int roundNumber = 1;
        int totalScore = 0;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;  // Generate a number between 1-100
            int attempts = 0;
            int maxAttempts = 10;
            boolean numberGuessed = false;

            System.out.println("\nRound " + roundNumber + ": You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (between 1 and 100): ");
                int userGuess;

                // Validate input to ensure it's a number in the correct range
                while (true) {
                    try {
                        userGuess = Integer.parseInt(scanner.next());
                        if (userGuess >= 1 && userGuess <= 100) {
                            break;
                        } else {
                            System.out.print("Please enter a number between 1 and 100: ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. Enter a number between 1 and 100: ");
                    }
                }

                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;
                    System.out.println("You earned " + points + " points in this round.");
                    numberGuessed = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!numberGuessed) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + targetNumber);
            }

            System.out.println("Total Score: " + totalScore);
            roundNumber++;

            // Prompt to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
