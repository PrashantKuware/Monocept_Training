package com.Assignment03;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String playAgain;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("Maximum possible attempts -> 5");
        System.out.println();

        do {

            int randomNumber = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessed = false;

            System.out.println("Random number generated: ");
            System.out.println();

            while (attempts < maxAttempts) {

                String input;
                int guess;

                while (true) {

                    System.out.print("Guess a number: ");
                    input = scanner.nextLine().trim();

                    if (!input.matches("\\d+")) {
                        System.out.println("Invalid input! Please enter a numeric value.");
                        continue;
                    }

                    guess = Integer.parseInt(input);

                    if (guess < 1 || guess > 100) {
                        System.out.println("Number must be between 1 and 100.");
                        continue;
                    }

                    break;
                }

                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Sorry too low");
                }
                else if (guess > randomNumber) {
                    System.out.println("Sorry too high");
                }
                else {
                    guessed = true;
                    System.out.println("You won: in attempt: " + attempts);
                    break;
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
                System.out.println();
            }

            if (!guessed) {
                System.out.println("Game Over! You used all attempts.");
                System.out.println("Correct number was: " + randomNumber);
            }

            while (true) {

                System.out.print("\nDo you want to play the game again (yes/no): ");
                playAgain = scanner.nextLine().trim().toLowerCase();

                if (playAgain.matches("yes|no")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                }
            }

            System.out.println();

        } while (playAgain.equals("yes"));

        System.out.println("Thank you for playing!");

        scanner.close();
    }
}