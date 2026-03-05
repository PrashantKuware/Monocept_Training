package tickTacToe_HumanVSComputer;

public abstract class Player 
{
	protected char symbol;
	
	public Player(char symbol)
	{
		this.symbol = symbol;
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public abstract void makeMove(Board board);
}
