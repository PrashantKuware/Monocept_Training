package tick_tac_toe_using_facade.test;

import tick_tac_toe_using_facade.model.facade.TicTacToeFacade;

public class GameStarter {
    public static void main(String[] args) {
        new TicTacToeFacade().startGame();
    }
}