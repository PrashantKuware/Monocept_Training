package TickTacToeUsingFacade;

public class Board 
{

    private char[] cells = new char[9];

    public Board() 
    {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i);
        }
    }

    public void printBoard() {
        System.out.println();
        System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2]);
        System.out.println("---|---|---");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);
        System.out.println("---|---|---");
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8]);
        System.out.println();
    }

    public char[] getBoard() {
        return cells;
    }
    
    public boolean placeMove(int position, char symbol) {

        if (position < 1 || position > 9) {
            return false;
        }

        if (cells[position - 1] == 'X' || cells[position - 1] == 'O') {
            return false;
        }

        cells[position - 1] = symbol;
        return true;
    }

    public boolean checkWin(char symbol) {

        int[][] patterns = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };

        for (int[] p : patterns) {
            if (cells[p[0]] == symbol &&
                cells[p[1]] == symbol &&
                cells[p[2]] == symbol) {
                return true;
            }
        }

        return false;
    }

    public boolean isDraw() {
        for (char c : cells) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }
}