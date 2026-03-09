package TickTacToe_Game.modified;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name1, name2;
        while(true)
        {
        	System.out.print("Enter Player 1 name: ");
            String tempName = scanner.nextLine().trim();
            if(tempName.matches("[a-zA-Z]+"))
            {
            	name1 = tempName;
            	break;
            }
            System.out.println("Enter correct name ");
        }
        
        while(true)
        {
        	System.out.print("Enter Player 2 name: ");
            String tempName = scanner.nextLine().trim();
            if(tempName.matches("[a-zA-Z]+"))
            {
            	name2 = tempName;
            	break;
            }
            System.out.println("Enter correct name ");
        }


        Player player1 = new Player(name1, 'X');
        Player player2 = new Player(name2, 'O');

        Board board = new Board();

        Player currentPlayer = player1;

        while (true) {

            board.printBoard();
            currentPlayer.makeMove(board);

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isDraw()) {
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }
}