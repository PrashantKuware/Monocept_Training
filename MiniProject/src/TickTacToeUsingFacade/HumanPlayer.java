package TickTacToeUsingFacade;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(char symbol, Scanner scanner) 
    {
        super(symbol);
        this.scanner = scanner;
    }

    @Override
    public void makeMove(Board board) 
    {
        while (true) 
        {
            System.out.print("Enter move (" + symbol + "): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.next();
                continue;
            }

            int pos = scanner.nextInt();

            if (board.placeMove(pos, symbol)) break;
            else System.out.println("Invalid move");
        }
    }
}