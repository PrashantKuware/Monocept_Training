package tick_tac_toe_using_facade.model.player;

import tick_tac_toe_using_facade.model.Board;

public abstract class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void makeMove(Board board);
}