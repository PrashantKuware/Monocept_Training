package TickTacToeUsingFacade;

import java.util.Scanner;

public class TicTacToeFacade 
{

    private Board board;
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public TicTacToeFacade() 
    {
        scanner = new Scanner(System.in);
    }

    public void startGame() 
    {

        while (true) 
        {
        	int choice;
        	while (true) {

        		   System.out.println();
        	    System.out.println("Select Mode:");
        	    System.out.println("1. Human vs Human");
        	    System.out.println("2. Human vs Computer");

        	    String tempChoice = scanner.nextLine().trim();

        	    if (tempChoice.matches("[12]")) {
        	        choice = Integer.parseInt(tempChoice);
        	        break;
        	    } else {
        	        System.out.println("❌ Invalid input! Please enter 1 or 2.");
        	    }
        	}

            board = new Board();

            if (choice == 1) {
                player1 = new HumanPlayer('X', scanner);
                player2 = new HumanPlayer('O', scanner);
            } else {
                player1 = new HumanPlayer('X', scanner);
                player2 = new ComputerPlayer('O');
            }

            runGame();

           
            System.out.print("\nDo you want to play again? (Y/N): ");
            String again = scanner.next().toUpperCase();

            if (!again.equals("Y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }

    private void runGame() {

        Player current = player1;

        while (true) {

            board.printBoard();
            current.makeMove(board);

            if (board.checkWin(current.getSymbol())) {
                board.printBoard();
                System.out.println("Player " + current.getSymbol() + " wins!");
                break;
            }

            if (board.isDraw()) {
                board.printBoard();
                System.out.println("Draw!");
                break;
            }

            current = (current == player1) ? player2 : player1;
        }
    }
}