package tick_tac_toe_using_facade.model.facade;


import tick_tac_toe_using_facade.model.*;
import tick_tac_toe_using_facade.model.player.ComputerPlayer;
import tick_tac_toe_using_facade.model.player.HumanPlayer;
import tick_tac_toe_using_facade.model.player.Player;
import tick_tac_toe_using_facade.model.validation.*;
import tick_tac_toe_using_facade.model.io.InputReader;

public class TicTacToeFacade {

    private Board board;
    private Player p1, p2;
    private InputReader input = new InputReader();

    public void startGame() {

        while (true) {

            int choice = Menu.showMenu(input);
            board = new Board();

            if (choice == 1) {
                p1 = new HumanPlayer('X', input);
                p2 = new HumanPlayer('O', input);
            } else {
                p1 = new HumanPlayer('X', input);
                p2 = new ComputerPlayer('O');
            }

            play();

            System.out.print("Play again? (Y/N): ");
            if (!input.readLine().equalsIgnoreCase("Y")) break;
        }
    }

    private void play() {
        Player current = p1;

        while (true) {
            board.printBoard();
            current.makeMove(board);

            if (GameValidator.checkWin(board.getCells(), current.getSymbol())) {
                board.printBoard();
                System.out.println("Winner: " + current.getSymbol());
                break;
            }

            if (GameValidator.isDraw(board.getCells())) {
                board.printBoard();
                System.out.println("Draw!");
                break;
            }

            current = (current == p1) ? p2 : p1;
        }
    }
}