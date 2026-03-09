package TickTacToe_Game.modified;

import java.util.Scanner;


public class Player {

    private String name;
    private char symbol;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void makeMove(Board board) {

        while (true) {
            System.out.print(name + " (" + symbol + "), enter position (1-9): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter number only.");
                scanner.next();
                continue;
            }

            int position = scanner.nextInt();

            if (board.placeMove(position, symbol)) {
                break;
            } else {
                System.out.println("Invalid or occupied position.");
            }
        }
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}