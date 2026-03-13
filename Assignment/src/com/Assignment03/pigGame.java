package com.Assignment03;

import java.util.Scanner;
import java.util.Random;

public class pigGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int turn = 0;

        System.out.println("Let's Play PIG!");
        System.out.println();
        System.out.println("See how many turns it takes you to get to 20.");
        System.out.println("Turn ends when you hold or roll a 1.");
        System.out.println("If you roll a 1, you lose all points for the turn.");
        System.out.println("If you hold, you save all points for the turn.");
        System.out.println();

        while (totalScore < 20) {

            turn++;
            int turnScore = 0;

            System.out.println("TURN " + turn);

            while (true) {

                String choice;

                while (true) {

                    System.out.print("Roll or hold? (r/h): ");
                    choice = sc.nextLine().trim().toLowerCase();

                    if (choice.matches("[rh]")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'r' to roll or 'h' to hold.");
                    }
                }

                if (choice.equals("r")) {

                    int die = rand.nextInt(6) + 1;
                    System.out.println("Die: " + die);

                    if (die == 1) {
                        turnScore = 0;
                        System.out.println("Turn over. No score.");
                        break;
                    }

                    turnScore += die;

                } else if (choice.equals("h")) {

                    totalScore += turnScore;

                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore);
                    break;
                }
            }

            System.out.println();
        }

        System.out.println("You finished in " + turn + " turns!");
        System.out.println();
        System.out.println("Game over!");

        sc.close();
    }
}