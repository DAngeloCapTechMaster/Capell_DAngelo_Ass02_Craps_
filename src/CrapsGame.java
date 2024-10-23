import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int initialRoll = rollDice(rnd);

            if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12) {
                System.out.println("Craps! You lose.");
            } else if (initialRoll == 7 || initialRoll == 11) {
                System.out.println("You rolled a natural! You win.");
            } else {
                int point = initialRoll;
                System.out.println("Point is set to: " + point);
                int roll;
                do {
                    roll = rollDice(rnd);
                    if (roll == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        break;
                    } else if (roll == point) {
                        System.out.println("You matched the point! You win.");
                        break;
                    } else {
                        System.out.println("Trying for point...");
                    }
                } while (true);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Method to simulate rolling two dice
    public static int rollDice(Random rnd) {
        return rnd.nextInt(6) + 1 + rnd.nextInt(6) + 1; // Sum of two dice rolls
    }
}
