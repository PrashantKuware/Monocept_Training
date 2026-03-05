package tickTacToe_HumanVSComputer;

public class Game 
{
	private Board board;
	private Player human;
	private Player computer;
	
	public Game(Player human, Player computer)
	{
		this.board = new Board();
		this.human = human;
		this.computer = computer;
				
	}
	
	public void start()
	{
		Player currentPlayer = human;
		
		while(true)
		{
			board.printBoard();
			currentPlayer.makeMove(board);
			
			if(board.isWin(currentPlayer.getSymbol()))
			{
				board.printBoard();
				System.out.println(currentPlayer.getSymbol()+" Win");
				break;
			}
			
			if(board.isDraw())
			{
				board.printBoard();
				System.out.println(" It's a Draw");
				break;
			}
			currentPlayer = (currentPlayer == human) ? computer : human;
		}
	}
}
