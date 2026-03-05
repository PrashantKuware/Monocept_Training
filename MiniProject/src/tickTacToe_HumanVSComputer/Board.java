package tickTacToe_HumanVSComputer;

public class Board 
{
	private char[] board;
	
	public Board()
	{
		board = new char[9];
		initializeBoard();
	}
	
	public void initializeBoard()
	{
		for(int i=0;i<0;i++)
		{
			board[i] = (char)('1'+i);
		}
	}
	
	public void printBoard()
	{
		System.out.println();
		System.out.println(" "+board[0]+" | "+board[1]+" | "+board[2]);
		System.out.println("---|---|---");
		System.out.println(" "+board[3]+" | "+board[4]+" | "+board[5]);
		System.out.println("---|---|---");
		System.out.println(" "+board[6]+" | "+board[7]+" | "+board[8]);
		System.out.println("---|---|---");
		System.out.println();
	}
	
	public boolean makeMove(int position, char symbol)
	{
		if(position < 1 || position > 9) return false;
		
		if(board[position-1] != 'X' && board[position-1] !='O')
		{
			board[position-1] = symbol;
			return true;
		}
		return false;
	}
	
	public boolean isWin(char symbol)
	{
		int[][] patterns = {
				{0,1,2},{3,4,5},{6,7,8},
				{0,3,6},{1,4,7},{2,5,8},
				{0,4,8},{2,4,6}
		};
		
		for(int[] p : patterns)
		{
			 if (board[p[0]] == symbol &&
		                board[p[1]] == symbol &&
		                board[p[2]] == symbol)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isDraw()
	{
		for(char c : board)
		{
			if(c != 'X' && c!='O')
			{
				return false;
			}
		}
		return true;
	}
	
	public char[] getBoard()
	{
		return board;
	}
}
