import java.util.Scanner;
import java.util.Random;

public class Numbergame {

  public static void main(String[] args) {
    Game();
  }

  public static void Game() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int randomnumber = random.nextInt(101);
    System.out.println("Welcome to the Game!");
    System.out.println("I'm thinking of a number between 1 and 100. Can You Guess it correctly!");
    System.out.println("You have only 5 Valid attempts");
    int maxattempts = 5;
    int guessCount = 0;
    boolean playAgain = true;
    while (playAgain) {
      guessCount = 0; 
      while (guessCount < maxattempts) {
        guessCount++;
        int guess;
        do {
          System.out.print("Enter your guess (attempt " + guessCount + " of " + maxattempts + "): ");
          String input = scanner.nextLine();
          try {
            guess = Integer.parseInt(input);
            break;
          } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a whole number between 1 and 100.");
          }
        } while (true);

        if (guess == randomnumber) {
          System.out.println("Congratulations! You guessed the number in " + guessCount + " tries.");
          break;
        } else if (guess < randomnumber) {
          System.out.println("Too low. Try again.");
        } else {
          System.out.println("Too high. Try again.");
        }
      }

      if (guessCount == maxattempts) {
        System.out.println("Out of attempts! The number was: " + randomnumber);
      }
      System.out.println("Do you want to play again? (y/n)");
      String answer = scanner.nextLine().toLowerCase();

      if (!answer.equals("y")) {
        playAgain = false;
      } else {
         randomnumber = random.nextInt(101);
      }
    }

    scanner.close();
  }
}







