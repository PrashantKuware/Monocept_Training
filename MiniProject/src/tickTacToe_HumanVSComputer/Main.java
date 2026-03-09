package tickTacToe_HumanVSComputer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		Player human = new HumanPlayer('X', scanner);
		Player computer = new ComputerPlayer('O');
		
		Game game= new Game(human, computer);
		game.start();
		scanner.close();
		
	}

}
