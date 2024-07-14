import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5; //max number of attempts
        int minNumber = 1;
        int maxNumber = 100; // Range of numbers

        while (true) {
            // Generating random number
            int randomNumber = (int) (Math.random() * (maxNumber - minNumber + 1)) + minNumber;

            // Starting the guessing loop
            int attempts = 0;
            boolean guessedCorrect = false;
            while (attempts < maxAttempts && !guessedCorrect) {
                System.out.printf("Guess a number between %d and %d (%d attempts left): ", minNumber, maxNumber, maxAttempts - attempts);
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    guessedCorrect = true;
                    System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                attempts++;
            }

            // Ask the user to play again
            if (!guessedCorrect) {
                System.out.println("You ran out of attempts. The number was: " + randomNumber);
            }
            System.out.print("Play again? (y/n): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
