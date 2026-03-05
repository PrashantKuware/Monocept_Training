package TickTacToe_Game;

import java.util.Scanner;

class TickTacToe 
{

	private char[][] board;
	private char currentPlayer = 'X';

	public TickTacToe() 
	{
		board = new char[3][3];
		initializeBoard();
	}

	void initializeBoard() 
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = ' ';
	}

	void displayBoard() 
	{
		System.out.println("\n-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println("\n-------------");
		}
	}

	boolean isValidMove(int row, int column) 
	{
		return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == ' ';
	}

	void makeMove(int row, int column) 
	{
		board[row][column] = currentPlayer;
	}

	void switchPlayer() 
	{
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	}

	boolean isBoardFull() 
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == ' ')
					return false;
		return true;
	}

	boolean checkWinner() 
	{

		for (int i = 0; i < 3; i++) 
		{
			if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
				return true;

			if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
				return true;
		}

		if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
			return true;

		if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
			return true;

		return false;
	}

	public static void main(String[] args) 
	{

		Scanner scanner = new Scanner(System.in);
		TickTacToe game = new TickTacToe();

		while (true) 
		{

			game.displayBoard();

			System.out.println("Player " + game.currentPlayer + " turn");
			System.out.print("Enter row (0-2): ");
			int row = scanner.nextInt();

			System.out.print("Enter column (0-2): ");
			int col = scanner.nextInt();

			if (!game.isValidMove(row, col)) {
				System.out.println("Invalid move! Try again.");
				continue;
			}

			game.makeMove(row, col);

			if (game.checkWinner()) 
			{
				game.displayBoard();
				System.out.println("Player " + game.currentPlayer + " wins!");
				break;
			}

			if (game.isBoardFull()) 
			{
				game.displayBoard();
				System.out.println("It's a Draw");
				break;
			}

			game.switchPlayer();
		}

		scanner.close();
	}
}