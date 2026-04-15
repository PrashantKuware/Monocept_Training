package tick_tac_toe_using_facade.model.player;


import tick_tac_toe_using_facade.model.*;
import tick_tac_toe_using_facade.model.validation.GameValidator;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    public void makeMove(Board board) {
        char[] c = board.getCells();

        // Win move
        for (int i = 0; i < 9; i++) {
            if (board.isCellEmpty(i)) {
                char temp = c[i];
                c[i] = getSymbol();
                if (GameValidator.checkWin(c, getSymbol())) return;
                c[i] = temp;
            }
        }

        // Block opponent
        char opponent = (getSymbol() == 'X') ? 'O' : 'X';
        for (int i = 0; i < 9; i++) {
            if (board.isCellEmpty(i)) {
                char temp = c[i];
                c[i] = opponent;
                if (GameValidator.checkWin(c, opponent)) {
                    c[i] = getSymbol();
                    return;
                }
                c[i] = temp;
            }
        }

        // Random
        Random r = new Random();
        while (true) {
            int pos = r.nextInt(9);
            if (board.isCellEmpty(pos)) {
                board.placeMove(pos, getSymbol());
                break;
            }
        }
    }
}