package tick_tac_toe_using_facade.model.player;


import tick_tac_toe_using_facade.model.*;
import tick_tac_toe_using_facade.model.validation.*;
import tick_tac_toe_using_facade.model.exception.*;
import tick_tac_toe_using_facade.model.io.InputReader;

public class HumanPlayer extends Player {

    private InputReader input;

    public HumanPlayer(char symbol, InputReader input) {
        super(symbol);
        this.input = input;
    }

    public void makeMove(Board board) {
        while (true) {
            try {
                System.out.print("Enter move (" + getSymbol() + "): ");
                int pos = input.readInt();

                GameValidator.validateMove(board.getCells(), pos);
                board.placeMove(CellMapper.map(pos), getSymbol());
                break;

            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}