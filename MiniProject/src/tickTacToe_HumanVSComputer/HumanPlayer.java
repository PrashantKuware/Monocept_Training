package tickTacToe_HumanVSComputer;

import java.util.Scanner;

public class HumanPlayer extends Player
{
	private Scanner scanner;
	public HumanPlayer(char symbol, Scanner scanner)
	{
		super(symbol);
		this.scanner=scanner;
	}
	
	@Override
	public void makeMove(Board board)
	{
		while(true)
		{
			System.out.print("Enter your move (1-9) : ");
			int position = scanner.nextInt();
			
			if(board.makeMove(position, symbol))
			{
				break;
			}
			else
			{
				System.out.print("Invalid move");
			}
		}
	}
}
