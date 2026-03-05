package tickTacToe_HumanVSComputer;

import java.util.Random;

public class ComputerPlayer extends Player
{
	public ComputerPlayer(char symbol)
	{
		super(symbol);
	}
	
	@Override
	public void makeMove(Board board)
	{
		System.out.println("Computer's move...");
		
		char[] currentBoard = board.getBoard();
		
		for(int i=0;i<9;i++)
		{
			if(currentBoard[i] != 'X' && currentBoard[i] != 'O')
			{
				char temp = currentBoard[i];
				currentBoard[i] = symbol;
				
				if(board.isWin(symbol)) return;
				
				currentBoard[i] = temp;
				
			}
		}
		char opponent = (symbol == 'X')?'O':'X';
		
		for(int i=0;i<9;i++)
		{
			if(currentBoard[i] != 'X' && currentBoard[i] != 'O')
			{
				char temp = currentBoard[i];
				currentBoard[i] = opponent;
				
				if(board.isWin(opponent) )
				{
					currentBoard[i] = symbol;
					return;
				}
				currentBoard[i] = temp;
			}
		}
		
		Random random = new Random();
		while(true)
		{
			int position = random.nextInt(9)+1;
			if(board.makeMove(position, symbol))
			{
				break;
			}
		}
	}
	
	
}
