package TickTacToeUsingFacade;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(char symbol) 
    {
        super(symbol);
    }

    @Override
    public void makeMove(Board board) {

        System.out.println("Computer's move...");

        char[] currentBoard = board.getBoard();

        // Try winning move
        for (int i = 0; i < 9; i++) {
            if (currentBoard[i] != 'X' && currentBoard[i] != 'O') 
            {

                char temp = currentBoard[i];
                currentBoard[i] = symbol;

                if (board.checkWin(symbol)) return;

                currentBoard[i] = temp;
            }
        }

        // Block opponent
        char opponent = (symbol == 'X') ? 'O' : 'X';

        for (int i = 0; i < 9; i++) {
            if (currentBoard[i] != 'X' && currentBoard[i] != 'O') {

                char temp = currentBoard[i];
                currentBoard[i] = opponent;

                if (board.checkWin(opponent)) {
                    currentBoard[i] = symbol;
                    return;
                }

                currentBoard[i] = temp;
            }
        }

        // Random move
        Random random = new Random();
        while (true) {
            int pos = random.nextInt(9) + 1;

            if (board.placeMove(pos, symbol)) break;
        }
    }
}